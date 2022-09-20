package com.company.entity;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString

public class Geo {

    @SerializedName("lng")
    private String lng;

    @SerializedName("lat")
    private String lat;
}