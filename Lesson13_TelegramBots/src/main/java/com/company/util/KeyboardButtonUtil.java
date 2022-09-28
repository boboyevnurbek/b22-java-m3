package com.company.util;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

public class KeyboardButtonUtil {
    public static ReplyKeyboardMarkup getBaseMenu(){
        KeyboardButton button1 = new KeyboardButton(KeyboardButtonConstants.MENU_DEMO);
        KeyboardButton button2 = new KeyboardButton(KeyboardButtonConstants.SETTINGS_DEMO);
        KeyboardButton button3 = new KeyboardButton("3-button");
        KeyboardButton button4 = new KeyboardButton("4-button");

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
}
