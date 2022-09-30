package com.company.voting.container;

import com.company.voting.bot.VotingBot;
import com.company.voting.entity.Candidate;
import com.company.voting.enums.AdminStatus;

import java.util.HashMap;
import java.util.Map;

public class ComponentContainer {
    public static VotingBot MY_BOT = null;
    public static String BOT_USERNAME = "";
    public static String BOT_TOKEN = "";
    public static String ADMIN_CHAT_ID = "616525392";

    public static boolean startElection = false;

    // adminChatId, AdminStatus
    public static Map<String, AdminStatus> statusMap = new HashMap<>();
    public static Map<String, Candidate> candidateMap = new HashMap<>();
}
