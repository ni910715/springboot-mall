package com.nidavid.springbootmall.service;

import com.nidavid.springbootmall.dto.CreateOrderRequest;
import com.nidavid.springbootmall.model.Order;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);
}
