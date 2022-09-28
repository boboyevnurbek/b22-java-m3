package com.company.controller;

import com.company.container.ComponentContainer;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.*;

import java.util.List;

public class MainController {
    public static void handleMessage(User user, Message message) {
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

    }

    private static void handleLocation(User user, Message message, Location location) {

    }

    private static void handleContact(User user, Message message, Contact contact) {

    }

    private static void handleText(User user, Message message, String text) {
        String chatId = String.valueOf(message.getChatId());

        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);

        if(text.equals("/start")){
            sendMessage.setText("Assalomu alaykum!");
        }else if(text.equalsIgnoreCase("/help")){
            sendMessage.setText("I can't help you");
        } else{
            sendMessage.setText(text);
        }

        ComponentContainer.MY_BOT.sendMsg(sendMessage);
    }

    public static void handleCallback(User user, Message message, String data) {

    }
}
