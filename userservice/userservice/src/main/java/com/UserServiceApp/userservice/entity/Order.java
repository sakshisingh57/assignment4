package com.UserServiceApp.userservice.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Setter
@Getter
@ToString
@Table(name = "orders")
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    @Id
    private Integer userId;
    @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer orderId;
    private Integer productId ;
    private Integer categoryId ;
    private Integer  quantity;
}
