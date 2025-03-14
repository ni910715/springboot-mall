package com.nidavid.springbootmall.service;

import com.nidavid.springbootmall.dto.CreateOrderRequest;
import com.nidavid.springbootmall.dto.OrderQueryParams;
import com.nidavid.springbootmall.model.Order;

import java.util.List;

public interface OrderService {
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);

    Order getOrderById(Integer orderId);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Integer countOrder(OrderQueryParams orderQueryParams);
}
