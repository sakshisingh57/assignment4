package com.UserServiceApp.userservice.controller;

import com.UserServiceApp.userservice.Request.PlaceAnOrder;
import com.UserServiceApp.userservice.Request.Product;
import com.UserServiceApp.userservice.entity.Order;
import com.UserServiceApp.userservice.entity.User;
import com.UserServiceApp.userservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private UserService userService;


    @PostMapping("/create")
    public User createUser(@RequestBody User user) {

       return userService.createUser(user);
    }

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable Integer userId) {
        return userService.getUser(userId);
    }

    @GetMapping("/allUsers")
    public List<User> getAllUsers() {

       return userService.getAllUsers();
    }

    @PutMapping("/update/{userId}")
    public User updateUsers(@RequestBody User user, @PathVariable Integer userId) {

        return userService.update(user, userId);
    }

    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable Integer userId) {
       userService.deleteUser(userId);
    }

    //Users would be able to place Order of Product
    @PostMapping("/placeOrder/{userId}")
    public Order placeAnOrder(@RequestBody PlaceAnOrder placeAnOrder, @PathVariable Integer userId)
    {

        return userService.placeAnOrder(placeAnOrder,userId);
    }

    //All Orders of User
    @GetMapping("/order/{userId}")
    public Order getOrder(@PathVariable Integer userId)
    {
        return userService.getOrder(userId);
    }

    //Order by orderId of User
    @GetMapping("order/orderId/{orderId}/{userId}")
    public Order AllOrders(@PathVariable Integer userId, @PathVariable Integer orderId)
    {
        return userService.AllOrders(userId,orderId);
    }

    //order update
    @PutMapping("update/order/{userId}")
    public Order updateOrder(@RequestBody Order order,@PathVariable Integer userId)
    {
        return userService.updateOrder(order,userId);
    }


}
