package com.company.entity;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Comment {

    @SerializedName("name")
    private String name;

    @SerializedName("postId")
    private Integer postId;

    @SerializedName("id")
    private Integer id;

    @SerializedName("body")
    private String body;

    @SerializedName("email")
    private String email;
}