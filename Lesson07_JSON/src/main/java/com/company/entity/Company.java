package com.company.entity;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Company {

    @SerializedName("bs")
    private String bs;

    @SerializedName("catchPhrase")
    private String catchPhrase;

    @SerializedName("name")
    private String name;
}