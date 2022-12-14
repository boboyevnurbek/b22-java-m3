package com.company.util;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class InlineKeyboardButtonUtil {
    public static InlineKeyboardMarkup getInlineMenu() {

        InlineKeyboardButton button1 = new InlineKeyboardButton("Export to Excel");
        button1.setCallbackData("_export_to_excel");

        InlineKeyboardButton button2 = new InlineKeyboardButton("Export to PDF");
        button2.setCallbackData("_export_to_pdf");

        InlineKeyboardButton button3 = new InlineKeyboardButton("For edit this message");
        button3.setCallbackData("_for_edit_message");

        List<InlineKeyboardButton> row = List.of(button1, button2);
        List<List<InlineKeyboardButton>> rowList = List.of(row, List.of(button3));

        return new InlineKeyboardMarkup(rowList);
    }
}
