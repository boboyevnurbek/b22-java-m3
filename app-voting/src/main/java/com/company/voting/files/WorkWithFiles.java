package com.company.voting.files;

import com.company.voting.db.Database;
import com.company.voting.entity.Candidate;
import com.company.voting.entity.Customer;
import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.List;

public interface WorkWithFiles {

    Gson GSON = new GsonBuilder().setPrettyPrinting().serializeNulls().create();

    String BASE_FOLDER = "src/main/resources/documents";
    File CUSTOMER_FILE = new File(BASE_FOLDER, "customers.json");
    File CANDIDATE_FILE = new File(BASE_FOLDER, "candidates.json");

    static void readCustomerList(){
        if(!CUSTOMER_FILE.exists()) return;

        try {
            List customers = GSON.fromJson(new BufferedReader(new FileReader(CUSTOMER_FILE)),
                    new TypeToken<List<Customer>>() {
                    }.getType());
            Database.customerList.clear();
            Database.customerList.addAll(customers);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void writeCustomerList(){
        try (PrintWriter writer = new PrintWriter(CUSTOMER_FILE)) {
            writer.write(GSON.toJson(Database.customerList));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void readCandidateList(){
        if(!CANDIDATE_FILE.exists()) return;

        try {
            List candidates = GSON.fromJson(new BufferedReader(new FileReader(CANDIDATE_FILE)),
                    new TypeToken<List<Candidate>>() {
                    }.getType());
            Database.candidateList.clear();
            Database.candidateList.addAll(candidates);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static void writeCandidateList() {
        try (PrintWriter writer = new PrintWriter(CANDIDATE_FILE)) {
            writer.write(GSON.toJson(Database.candidateList));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
