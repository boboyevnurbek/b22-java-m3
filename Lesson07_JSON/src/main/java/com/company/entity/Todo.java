package com.company.entity;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Todo {

    @SerializedName("id")
    private Integer id;

    @SerializedName("completed")
    private Boolean completed;

    @SerializedName("title")
    private String title;

    @SerializedName("userId")
    private Integer userId;
}