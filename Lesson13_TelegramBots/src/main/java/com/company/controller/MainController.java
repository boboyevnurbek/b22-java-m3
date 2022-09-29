package com.company.controller;

import com.company.container.ComponentContainer;
import com.company.entity.Customer;
import com.company.files.WorkWithFiles;
import com.company.service.CustomerService;
import com.company.util.InlineKeyboardButtonUtil;
import com.company.util.KeyboardButtonConstants;
import com.company.util.KeyboardButtonUtil;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendDocument;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.DeleteMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.Collections;
import java.util.List;

public class MainController {
    public static void handleMessage(User user, Message message) {
        String chatId = String.valueOf(message.getChatId());

//        if(chatId.equals(ComponentContainer.ADMIN_CHAT_ID)){
//            AdminController.handleMessage(user, message);
//            return;
//        }

        if(message.hasText()){
            String text = message.getText();
            handleText(user, message, text);
        }else if(message.hasContact()){
            Contact contact = message.getContact();
            handleContact(user, message, contact);
        }else if(message.hasLocation()){
            Location location = message.getLocation();
            handleLocation(user, message, location);
        }else if(message.hasPhoto()){
            List<PhotoSize> photoSizeList = message.getPhoto();
            handlePhoto(user, message, photoSizeList);
        }
    }

    private static void handlePhoto(User user, Message message, List<PhotoSize> photoSizeList) {

        String fileId = photoSizeList.get(photoSizeList.size() - 1).getFileId();
        //System.out.println(fileId);

        ComponentContainer.MY_BOT.imageList.add(fileId);

        Collections.shuffle(ComponentContainer.MY_BOT.imageList);

        String chatId = String.valueOf(message.getChatId());

        SendPhoto sendPhoto1 = new SendPhoto();
        sendPhoto1.setChatId(chatId);
        sendPhoto1.setPhoto(new InputFile(ComponentContainer.MY_BOT.imageList.get(0)));
        sendPhoto1.setCaption("This is simple image");
        ComponentContainer.MY_BOT.sendMsg(sendPhoto1);

//        SendMessage sendMessage = new SendMessage(chatId, "Your image received");
//        ComponentContainer.MY_BOT.sendMsg(sendMessage);

        SendPhoto sendPhoto = new SendPhoto();
        sendPhoto.setChatId(ComponentContainer.ADMIN_CHAT_ID);
        sendPhoto.setPhoto(new InputFile(fileId));
        sendPhoto.setCaption("This is image");
        ComponentContainer.MY_BOT.sendMsg(sendPhoto);

    }

    private static void handleLocation(User user, Message message, Location location) {
        String chatId = String.valueOf(message.getChatId());

        SendMessage sendMessage = new SendMessage(chatId, "Your location received");
        ComponentContainer.MY_BOT.sendMsg(sendMessage);

        Double latitude = location.getLatitude();
        Double longitude = location.getLongitude();

        Customer customer = CustomerService.getCustomerByChatId(chatId);
        SendMessage sendMessage1 = new SendMessage();
        sendMessage1.setChatId(ComponentContainer.ADMIN_CHAT_ID);

        StringBuilder sb = new StringBuilder();

        if(customer != null){
            sb.append("<b>Customer: </b> "+customer.getFirstName()+" "+customer.getLastName());
            sb.append("\n\n");
            sb.append("<b>Phone number: </b>"+customer.getPhoneNumber());
            sb.append("\n\n");

            sb.append("<a href='https://yandex.uz/maps/org/132435894010/?ll="+
                    longitude+"%2C"+latitude+"&z=14'> Xaritadan ko'rish </a>");
        }else {
            sb.append("<b style='color:red'>This customer not found</b>");
        }

        sendMessage1.setText(sb.toString());
        sendMessage1.setParseMode(ParseMode.HTML);
        sendMessage1.setDisableWebPagePreview(true);
        ComponentContainer.MY_BOT.sendMsg(sendMessage1);

    }

    private static void handleContact(User user, Message message, Contact contact) {
        String chatId = String.valueOf(message.getChatId());

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        Customer customer = CustomerService.getCustomerByChatId(chatId);
        if(customer != null){
            sendMessage.setText("Your contact already saved 😀");
        }else{
            Customer addCustomer = CustomerService.addCustomer(chatId, contact);
            sendMessage.setText("Your contact successfully saved 😀");

            // FOR ADMIN
            SendMessage msg = new SendMessage(ComponentContainer.ADMIN_CHAT_ID,
                    "new customer : "+addCustomer);
            ComponentContainer.MY_BOT.sendMsg(msg);
        }

        sendMessage.setReplyMarkup(KeyboardButtonUtil.getBaseMenu());
        ComponentContainer.MY_BOT.sendMsg(sendMessage);
    }

    private static void handleText(User user, Message message, String text) {
        String chatId = String.valueOf(message.getChatId());

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        if(text.equals("/start")){

            Customer customer = CustomerService.getCustomerByChatId(chatId);
            if(customer == null){
                sendMessage.setText("Hello!\nSend your number");
                sendMessage.setReplyMarkup(KeyboardButtonUtil.getContactMenu());
            }else{
                sendMessage.setText("Hello!");
                sendMessage.setReplyMarkup(KeyboardButtonUtil.getBaseMenu());
            }
        }else if(text.equalsIgnoreCase("/help")){
            sendMessage.setText("I can't help you");
        }
        else if(text.equalsIgnoreCase("/menu")){

//            sendMessage.setText("*Choose: *");
//            sendMessage.setParseMode(ParseMode.MARKDOWNV2);

            sendMessage.setText("<b><u> Choose: </u></b>");
            sendMessage.setParseMode(ParseMode.HTML);

            sendMessage.setReplyMarkup(KeyboardButtonUtil.getBaseMenu());
        }
        else if(text.equalsIgnoreCase(KeyboardButtonConstants.MENU_DEMO)){
            sendMessage.setText("MENU button clicked");
        }else if(text.equalsIgnoreCase(KeyboardButtonConstants.SETTINGS_DEMO)){
            sendMessage.setText("SETTINGS button clicked");
        }else if(text.equalsIgnoreCase(KeyboardButtonConstants.INLINES_DEMO)){
            sendMessage.setText("This is inline buttons");
            sendMessage.setReplyMarkup(InlineKeyboardButtonUtil.getInlineMenu());
        }
        else{
            sendMessage.setText(text);
        }

        ComponentContainer.MY_BOT.sendMsg(sendMessage);
    }

    public static void handleCallback(User user, Message message, String data) {
        String chatId = String.valueOf(message.getChatId());

        if(data.equals("_export_to_excel")){

            DeleteMessage deleteMessage = new DeleteMessage(chatId, message.getMessageId());
            ComponentContainer.MY_BOT.sendMsg(deleteMessage);

            SendDocument sendDocument = new SendDocument();
            sendDocument.setChatId(chatId);
            sendDocument.setDocument(new InputFile(WorkWithFiles.generateCustomerExcelFile()));
            ComponentContainer.MY_BOT.sendMsg(sendDocument);

        }else if(data.equals("_export_to_pdf")){
//            SendMessage sendMessage = new SendMessage(chatId, "loading...");
//            ComponentContainer.MY_BOT.sendMsg(sendMessage);

            DeleteMessage deleteMessage = new DeleteMessage(chatId, message.getMessageId());
            ComponentContainer.MY_BOT.sendMsg(deleteMessage);

            SendDocument sendDocument = new SendDocument();
            sendDocument.setChatId(chatId);
            sendDocument.setDocument(new InputFile(WorkWithFiles.generateCustomerPdfFile()));
            ComponentContainer.MY_BOT.sendMsg(sendDocument);

        }else if(data.equals("_for_edit_message")){
            EditMessageText editMessageText = new EditMessageText();
            editMessageText.setChatId(chatId);
            editMessageText.setMessageId(message.getMessageId());
            editMessageText.setText("This edited text");
            ComponentContainer.MY_BOT.sendMsg(editMessageText);
        }
    }
}
