package com.company.dict.entity;


import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Word {
    // unique
    private String eng;
    private List<String> uzb = new ArrayList<>();

    @Override
    public String toString() {
        return eng + " : " + uzb;
    }
}
