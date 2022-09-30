package com.company.voting.controller;

import com.company.voting.container.ComponentContainer;
import com.company.voting.db.Database;
import com.company.voting.entity.Candidate;
import com.company.voting.entity.Customer;
import com.company.voting.enums.AdminStatus;
import com.company.voting.files.WorkWithFiles;
import com.company.voting.service.CandidateService;
import com.company.voting.util.InlineButtonConstants;
import com.company.voting.util.InlineKeyboardUtil;
import com.company.voting.util.KeyboardButtonConstants;
import com.company.voting.util.KeyboardButtonUtil;
import lombok.AllArgsConstructor;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.objects.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class AdminController {
    public static void handleMessage(User user, Message message) {

        if (message.hasText()) {
            String text = message.getText();
            handleText(user, message, text);
        } else if (message.hasPhoto()) {
            List<PhotoSize> photoSizeList = message.getPhoto();
            handlePhoto(user, message, photoSizeList);
        }
    }

    private static void handlePhoto(User user, Message message, List<PhotoSize> photoSizeList) {
        String chatId = String.valueOf(message.getChatId());

        String fileId = photoSizeList.get(photoSizeList.size() - 1).getFileId();

        if (ComponentContainer.statusMap.containsKey(chatId)) {
            AdminStatus adminStatus = ComponentContainer.statusMap.get(chatId);
            if (adminStatus.equals(AdminStatus.SEND_PHOTO)) {
                Candidate candidate = ComponentContainer.candidateMap.get(chatId);
                candidate.setFileId(fileId);

                ComponentContainer.statusMap.put(chatId, AdminStatus.ENTER_FULL_NAME);

                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(chatId);
                sendMessage.setText("Ism familiyani kiriting: ");
                ComponentContainer.MY_BOT.sendMsg(sendMessage);
            }
        }

    }

    private static void handleText(User user, Message message, String text) {
        String chatId = String.valueOf(message.getChatId());

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        if (text.equals("/start")) {
            sendMessage.setText("Hello Admin");
            sendMessage.setReplyMarkup(KeyboardButtonUtil.getAdminMenu());
            ComponentContainer.MY_BOT.sendMsg(sendMessage);
        } else if (text.equals(KeyboardButtonConstants.ADD_CANDIDATE)) {

            ComponentContainer.statusMap.put(chatId, AdminStatus.SEND_PHOTO);
            ComponentContainer.candidateMap.put(chatId, new Candidate());

            sendMessage.setText("Nomzodning rasmini yuboring:");
            ComponentContainer.MY_BOT.sendMsg(sendMessage);


        } else if (text.equals(KeyboardButtonConstants.START_ELECTION)) {
            if (Database.candidateList.isEmpty()) {
                sendMessage.setText("Nomzodlar yo'q");
            } else if (ComponentContainer.startElection) {
                sendMessage.setText("Saylov davom etyapti.");
            }else{
                ComponentContainer.startElection = true;
                sendMessage.setText("Saylov boshlandi.");

                sendMessageToCustomersForElection();

                sendMessageToCustomers("Saylov boshlandi.");
            }
            ComponentContainer.MY_BOT.sendMsg(sendMessage);
        } else if (text.equals(KeyboardButtonConstants.FINISH_ELECTION)) {
            if (!ComponentContainer.startElection) {
                sendMessage.setText("Saylov umuman boshlanmagan. Uni yakunlash manosiz.");
            }else{
                ComponentContainer.startElection = false;
                sendMessage.setText("Saylov yakunlandi.");

                sendMessageToCustomers("Saylov yakunlandi.");

                StringBuilder sb = new StringBuilder("Natijalar: \n\n");

                Database.candidateList.sort((c1, c2) -> Integer.compare(c2.getCountVotes(), c1.getCountVotes()));

                for (Candidate candidate : Database.candidateList) {
                    sb.append(candidate.getFullName()+" : "+candidate.getCountVotes()+"\n");
                }

                sendMessageToCustomers(sb.toString());

                SendMessage sendMessage1 = new SendMessage(chatId, sb.toString());
                ComponentContainer.MY_BOT.sendMsg(sendMessage1);

                // Database.candidateList.clear();

                for (Candidate candidate : Database.candidateList) {
                    candidate.setCountVotes(0);
                }
                WorkWithFiles.writeCandidateList();

                for (Customer customer : Database.customerList) {
                    customer.setHasVoted(false);
                }
                WorkWithFiles.writeCustomerList();

            }
            ComponentContainer.MY_BOT.sendMsg(sendMessage);
        } else if (text.equals(KeyboardButtonConstants.SHOW_COUNT_VOICE)) {
            StringBuilder sb = new StringBuilder("Hozircha ovozlar soni: \n\n");

            Database.candidateList.sort((c1, c2) -> Integer.compare(c2.getCountVotes(), c1.getCountVotes()));

            for (Candidate candidate : Database.candidateList) {
                sb.append(candidate.getFullName()+" : "+candidate.getCountVotes()+"\n");
            }
            sendMessage.setText(sb.toString()+ LocalDateTime.now()+" paytiga ko'ra");

            ComponentContainer.MY_BOT.sendMsg(sendMessage);
        } else {
            if (ComponentContainer.statusMap.containsKey(chatId)) {
                AdminStatus adminStatus = ComponentContainer.statusMap.get(chatId);
                if (adminStatus.equals(AdminStatus.ENTER_FULL_NAME)) {
                    Candidate candidate = ComponentContainer.candidateMap.get(chatId);
                    candidate.setFullName(text);

                    ComponentContainer.statusMap.put(chatId, AdminStatus.ENTER_AGE);

                    sendMessage.setText(text + " ning yoshini kiriting: ");
                    ComponentContainer.MY_BOT.sendMsg(sendMessage);
                } else if (adminStatus.equals(AdminStatus.ENTER_AGE)) {
                    int age = -5;
                    try {
                        age = Integer.parseInt(text);
                    } catch (Exception e) {

                    }

                    if (age <= 0) {
                        sendMessage.setText("Yosh xato kiritildi. Qayta kiriting: ");
                        ComponentContainer.MY_BOT.sendMsg(sendMessage);
                    } else {

                        Candidate candidate = ComponentContainer.candidateMap.get(chatId);
                        candidate.setAge(age);

                        ComponentContainer.statusMap.put(chatId, AdminStatus.ENTER_DESCRIPTION);

                        sendMessage.setText(candidate.getFullName() + " haqida qo'shimcha malumot kiriting: ");
                        ComponentContainer.MY_BOT.sendMsg(sendMessage);
                    }
                } else if (adminStatus.equals(AdminStatus.ENTER_DESCRIPTION)) {
                    Candidate candidate = ComponentContainer.candidateMap.get(chatId);
                    candidate.setDescription(text);

                    ComponentContainer.statusMap.put(chatId, AdminStatus.CONFIRM_OR_CANCEL);

                    SendPhoto sendPhoto = new SendPhoto(chatId, new InputFile(candidate.getFileId()));
                    StringBuilder sb = new StringBuilder();

                    sb.append("To'liq FIO: " + candidate.getFullName() + "\n");
                    sb.append("Yosh: " + candidate.getAge() + "\n");
                    sb.append("Qo'shimcha: " + candidate.getDescription() + "\n");

                    sendPhoto.setCaption(sb.toString());

                    sendPhoto.setReplyMarkup(InlineKeyboardUtil.getConfirmOrCancelMenu());

                    ComponentContainer.MY_BOT.sendMsg(sendPhoto);
                }
            }
        }

    }

    private static void sendMessageToCustomersForElection() {

        for (Customer customer : Database.customerList) {
            for (Candidate candidate : Database.candidateList) {
                new MyThread(candidate, customer).start();
            }
        }

    }

    private static void sendMessageToCustomers(String message) {
        for (Customer customer : Database.customerList) {
            SendMessage sendMessage = new SendMessage(customer.getChatId(), message);
            ComponentContainer.MY_BOT.sendMsg(sendMessage);
        }
    }

    public static void handleCallback(User user, Message message, String data) {
        String chatId = String.valueOf(message.getChatId());

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        if (data.equals(InlineButtonConstants.CONFIRM_CALL_BACK)) {
            Candidate candidate = ComponentContainer.candidateMap.get(chatId);
            CandidateService.addCandidate(candidate);

            sendMessage.setText(candidate.getFullName() + " muvaffaqiyatli saqlandi.");
        } else if (data.equals(InlineButtonConstants.CANCEL_CALL_BACK)) {
            Candidate candidate = ComponentContainer.candidateMap.get(chatId);
            sendMessage.setText(candidate.getFullName() + " saqlanmadi.");
        }

        ComponentContainer.statusMap.remove(chatId);
        ComponentContainer.candidateMap.remove(chatId);

        ComponentContainer.MY_BOT.sendMsg(sendMessage);

        DeleteMessage deleteMessage = new DeleteMessage(chatId, message.getMessageId());
        ComponentContainer.MY_BOT.sendMsg(deleteMessage);
    }
}

@AllArgsConstructor
class MyThread extends Thread{
    private Candidate candidate;
    private Customer customer;

    @Override
    public void run() {
        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(customer.getChatId());
        sendPhoto.setPhoto(new InputFile(candidate.getFileId()));
        sendPhoto.setCaption(candidate.getFullName()+"\n"+candidate.getDescription());

        sendPhoto.setReplyMarkup(InlineKeyboardUtil.getVotingMenu(candidate.getId(), candidate.getCountVotes()));
        ComponentContainer.MY_BOT.sendMsg(sendPhoto);

    }
}