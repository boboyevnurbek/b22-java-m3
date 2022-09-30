package com.company.voting.db;

import com.company.voting.entity.Candidate;
import com.company.voting.entity.Customer;
import org.telegram.telegrambots.meta.api.objects.Message;

import java.util.ArrayList;
import java.util.List;

public interface Database {
    List<Customer> customerList = new ArrayList<>();
    List<Candidate> candidateList = new ArrayList<>();
    List<Message> messageList = new ArrayList<>();
}
