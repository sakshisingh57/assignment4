package com.UserServiceApp.userservice.Request;

import lombok.*;

@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class PlaceAnOrder {

    private String productName;
    private Integer quantity;
    private String category;

}
