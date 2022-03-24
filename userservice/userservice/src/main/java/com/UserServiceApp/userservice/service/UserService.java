package com.UserServiceApp.userservice.service;

import com.UserServiceApp.userservice.Request.Category;
import com.UserServiceApp.userservice.Request.PlaceAnOrder;
import com.UserServiceApp.userservice.Request.Product;
import com.UserServiceApp.userservice.entity.Order;
import com.UserServiceApp.userservice.entity.User;
import com.UserServiceApp.userservice.repository.OrderRepository;
import com.UserServiceApp.userservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements ProductCatalogServiceClient {


    @Autowired
    private UserRepository userRepository;

    @Autowired
    @Lazy
    private ProductCatalogServiceClient productCatalogServiceClient;

    @Autowired
    private OrderRepository orderRepository;

    public User createUser(User user) {
        List<User> users = userRepository.findAll();
        users = new ArrayList<>();
        User user1 = new User();
        user1.setUserId(user.getUserId());
        user1.setUserName(user.getUserName());
        user1.setFirstName(user.getFirstName());
        user1.setLastName(user.getLastName());
        user1.setPassword(user.getPassword());
        user1.setEmail(user.getEmail());
        users.add(user1);
        userRepository.save(user);
        return user1;
    }

    public User getUser(Integer userId) {

        return userRepository.findByUserId(userId);

    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User update(User user, Integer userId) {
        User getUser = userRepository.findByUserId(userId);
        if (getUser != null) {
            getUser.setUserId(user.getUserId());
            getUser.setUserName(user.getUserName());
            getUser.setFirstName(user.getFirstName());
            getUser.setLastName(user.getLastName());
            getUser.setPassword(user.getPassword());
            getUser.setEmail(user.getEmail());
            userRepository.save(getUser);
        }

        return user;

    }

    public void deleteUser(Integer userId) {
        userRepository.deleteById(userId);


    }

    @Override
    public List<Product> getProduct() {
        return productCatalogServiceClient.getProduct();
    }

    @Override
    public Product getProductByProductId(Integer productId) {
        return productCatalogServiceClient.getProductByProductId(productId);
    }

    @Override
    public Product getProductByProductName(String productName) {
        return productCatalogServiceClient.getProductByProductName(productName);
    }

    @Override
    public Category getCategoryByCategoryName(String categoryName) {
        return productCatalogServiceClient.getCategoryByCategoryName(categoryName);
    }

    public Order placeAnOrder(PlaceAnOrder placeAnOrder,Integer userId)
    {
       Product productAvailable=getProductByProductName(placeAnOrder.getProductName());
       if(productAvailable==null)
       {
           throw new RuntimeException("product not available");
       }
     Category categoryAvailable=getCategoryByCategoryName(placeAnOrder.getCategory());
       if (categoryAvailable==null) {
           throw new RuntimeException("category given is not matching");
       }
       Order order=new Order();
       order.setOrderId(1);
       order.setUserId(userId);
       order.setCategoryId(categoryAvailable.getCategoryId());
       order.setProductId(productAvailable.getProductId());
       order.setQuantity(placeAnOrder.getQuantity());
       orderRepository.save(order);

       return order;
    }

    public Order getOrder(Integer userId)
    {
        return orderRepository.findByUserId(userId);

    }

    public Order AllOrders(Integer userId,Integer orderId)
    {
        return orderRepository.findByUserIdAndOrderId(userId,orderId);

    }

    public Order updateOrder(Order order,Integer userId)
    {
     Order order1=orderRepository.findByUserId(userId);
     order1.setOrderId(order.getOrderId());
     order1.setUserId(order.getUserId());
     order1.setProductId(order.getProductId());
     order1.setQuantity(order.getQuantity());
     order1.setCategoryId(order.getCategoryId());
     orderRepository.save(order1);
     return order1;
    }
}
