package com.company.voting.util;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.List;

public class KeyboardButtonUtil {

    public static ReplyKeyboard getAdminMenu() {
        List<KeyboardRow> rowList = getRowList(
                getRow(getButton(KeyboardButtonConstants.ADD_CANDIDATE)),
                getRow(
                        getButton(KeyboardButtonConstants.START_ELECTION),
                        getButton(KeyboardButtonConstants.FINISH_ELECTION)
                ),
                getRow(getButton(KeyboardButtonConstants.SHOW_COUNT_VOICE)
                ));

        return getMarkup(rowList);
    }

    private static KeyboardButton getButton(String demo) {
        return new KeyboardButton(demo);
    }

    private static KeyboardRow getRow(KeyboardButton... buttons) {
        return new KeyboardRow(List.of(buttons));
    }

    private static List<KeyboardRow> getRowList(KeyboardRow... rows) {
        return List.of(rows);
    }

    private static ReplyKeyboardMarkup getMarkup(List<KeyboardRow> rowList) {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup(rowList);
        markup.setResizeKeyboard(true);
        markup.setSelective(true);
        return markup;
    }

    public static ReplyKeyboard getContactMenu() {
        KeyboardButton button = getButton("Raqamingizni jo'nating.");
        button.setRequestContact(true);

        return getMarkup(getRowList(getRow(button)));
    }

    public static ReplyKeyboard getCustomerMenu() {

        return getMarkup(getRowList(getRow(
                getButton(KeyboardButtonConstants.ACCESS_VOTE),
                getButton(KeyboardButtonConstants.SHOW_COUNT_VOICE)
        )));
    }
}
