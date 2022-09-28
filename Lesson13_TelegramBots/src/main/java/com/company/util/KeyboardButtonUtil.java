package com.company.util;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

public class KeyboardButtonUtil {
    public static ReplyKeyboardMarkup getBaseMenu(){
        KeyboardButton button1 = new KeyboardButton(KeyboardButtonConstants.MENU_DEMO);
        KeyboardButton button2 = new KeyboardButton(KeyboardButtonConstants.SETTINGS_DEMO);

        KeyboardButton button3 = new KeyboardButton("Send phone number");
        button3.setRequestContact(true);

        KeyboardButton button4 = new KeyboardButton("Send location");
        button4.setRequestLocation(true);

        KeyboardRow row1 = new KeyboardRow();
        row1.add(button1);
        row1.add(button2);

        KeyboardRow row2 = new KeyboardRow(List.of(button3));
        KeyboardRow row3 = new KeyboardRow(List.of(button4));

        List<KeyboardRow> rowList = List.of(row1, row2, row3);

        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup(rowList);

//        markup.setOneTimeKeyboard(true);
        markup.setSelective(true);
        markup.setResizeKeyboard(true);

        return markup;
    }

    public static ReplyKeyboard getContactMenu() {
        KeyboardButton button = new KeyboardButton("Send phone number");
        button.setRequestContact(true);
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup(
                List.of(new KeyboardRow(List.of(button))));
        markup.setResizeKeyboard(true);
        return markup;
    }
}
