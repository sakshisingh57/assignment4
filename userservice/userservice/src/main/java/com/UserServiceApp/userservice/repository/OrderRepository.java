package com.UserServiceApp.userservice.repository;

import com.UserServiceApp.userservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {

    Order findByUserId(Integer userId);
    Order findByUserIdAndOrderId(Integer userId,Integer orderId);
}
