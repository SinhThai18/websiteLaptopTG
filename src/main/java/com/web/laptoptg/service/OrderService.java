package com.web.laptoptg.service;

import com.web.laptoptg.model.Order;
import com.web.laptoptg.model.User;
import java.util.List;

public interface OrderService {
    Order getOrderById(int id);
    List<Order> getAllOrders();
    void deleteOrderById(int id);
    List<Order> searchOrdersByPhone(String phoneNumber);
    void updateOrder(Order order);
    void saveOrder(Order order);
}
