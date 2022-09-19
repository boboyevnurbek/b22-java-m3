package com.company.entity;

import com.google.gson.annotations.SerializedName;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Car {

    transient private String model="Best matiz";

    private double price;

    @SerializedName(value = "license plate")
    private String licensePlate;
}

//{
//    "model": "Malibu",
//    "price": 2000
//     "license plate": "01A001AA"
//}