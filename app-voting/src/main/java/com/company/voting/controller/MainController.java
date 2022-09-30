package com.company.voting.controller;

import com.company.voting.container.ComponentContainer;
import com.company.voting.db.Database;
import com.company.voting.entity.Candidate;
import com.company.voting.entity.Customer;
import com.company.voting.files.WorkWithFiles;
import com.company.voting.service.CandidateService;
import com.company.voting.service.CustomerService;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.*;

import java.util.Collections;
import java.util.List;

public class MainController {
    public static void handleMessage(User user, Message message) {

        if (message.hasText()) {
            String text = message.getText();
            handleText(user, message, text);
        } else if (message.hasContact()) {
            Contact contact = message.getContact();
            handleContact(user, message, contact);
        }
    }

    private static void handleContact(User user, Message message, Contact contact) {
        String chatId = String.valueOf(message.getChatId());
    }

    private static void handleText(User user, Message message, String text) {
        String chatId = String.valueOf(message.getChatId());

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        Customer customer = CustomerService.getCustomerByChatId(chatId);

        if(customer == null){
            CustomerService.addCustomer(chatId,
                    new Contact("+998901234567", "f", "l", 1234567l, "vcard"));
        }

        if (text.equals("/start")) {
            sendMessage.setText("Assalomu alaykum!");
            ComponentContainer.MY_BOT.sendMsg(sendMessage);
        }

    }

    public static void handleCallback(User user, Message message, String data) {
        String chatId = String.valueOf(message.getChatId());

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        if (data.startsWith("voting/")) {
            String[] split = data.split("/");
            String candidateId = split[1];

            Candidate candidate = CandidateService.getCandidateById(candidateId);
            Customer customer = CustomerService.getCustomerByChatId(chatId);

            if (!customer.isHasVoted()) {
                customer.setHasVoted(true);
                candidate.setCountVotes(candidate.getCountVotes() + 1);

                WorkWithFiles.writeCustomerList();
                WorkWithFiles.writeCandidateList();

                sendMessage.setText("siz "+candidate.getFullName()+" ga ovoz berdingiz.");

                for (Message message1 : Database.messageList) {
                    DeleteMessage deleteMessage = new DeleteMessage(message1.getChatId().toString(), message1.getMessageId());
                    ComponentContainer.MY_BOT.sendMsg(deleteMessage);
                }

                Database.messageList.removeIf(message1 -> message1.getChatId().toString().equals(chatId));

            }else{
                sendMessage.setText("siz avval ovoz bergansiz");
            }

            ComponentContainer.MY_BOT.sendMsg(sendMessage);
        }


    }

}

