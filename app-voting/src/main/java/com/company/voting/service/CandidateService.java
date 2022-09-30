package com.company.voting.service;

import com.company.voting.db.Database;
import com.company.voting.entity.Candidate;
import com.company.voting.files.WorkWithFiles;

import java.util.UUID;

public class CandidateService {
    public static Candidate getCandidateById(String id){
        return Database.candidateList.stream()
                .filter(candidate -> candidate.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    public static Candidate addCandidate(Candidate reqCandidate){
        Candidate candidate = new Candidate(String.valueOf(UUID.randomUUID()),
                reqCandidate.getFileId(),
                reqCandidate.getFullName(),
                reqCandidate.getAge(),
                reqCandidate.getDescription());

        Database.candidateList.add(candidate);
        WorkWithFiles.writeCandidateList();
        return candidate;
    }
}
