package com.nidavid.springbootmall.service;

import com.nidavid.springbootmall.dto.CreateOrderRequest;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}
