package com.company.voting.bot;

import com.company.voting.container.ComponentContainer;
import com.company.voting.files.WorkWithFiles;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) {

        try {

            WorkWithFiles.readCustomerList();
            WorkWithFiles.readCandidateList();

            TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);

            VotingBot myBot = new VotingBot();
            ComponentContainer.MY_BOT = myBot;

            botsApi.registerBot(myBot);

        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

    }
}
