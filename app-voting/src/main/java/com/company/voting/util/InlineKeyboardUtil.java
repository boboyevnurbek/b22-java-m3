package com.company.voting.util;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.List;

public class InlineKeyboardUtil {
    public static InlineKeyboardMarkup getConfirmOrCancelMenu() {
        InlineKeyboardButton confirm = new InlineKeyboardButton(InlineButtonConstants.CONFIRM_DEMO);
        confirm.setCallbackData(InlineButtonConstants.CONFIRM_CALL_BACK);

        InlineKeyboardButton cancel = new InlineKeyboardButton(InlineButtonConstants.CANCEL_DEMO);
        cancel.setCallbackData(InlineButtonConstants.CANCEL_CALL_BACK);

        return new InlineKeyboardMarkup(List.of(
                List.of(confirm, cancel)
        ));
    }


    public static InlineKeyboardMarkup getVotingMenu(String candidateId) {

        InlineKeyboardButton button = new InlineKeyboardButton("Ovoz berish");
        button.setCallbackData("voting/"+candidateId);

        return new InlineKeyboardMarkup(List.of(List.of(button)));
    }

    public static InlineKeyboardMarkup getConnectMarkup(String chatId) {
        InlineKeyboardButton button = new InlineKeyboardButton(InlineButtonConstants.REPLY_DEMO);
        button.setCallbackData(InlineButtonConstants.REPLY_CALL_BACK+"/"+chatId);

        return new InlineKeyboardMarkup(List.of(List.of(button)));
    }
}
