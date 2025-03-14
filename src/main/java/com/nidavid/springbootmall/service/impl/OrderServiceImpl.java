package com.nidavid.springbootmall.service.impl;

import com.nidavid.springbootmall.dao.OrderDao;
import com.nidavid.springbootmall.dao.ProductDao;
import com.nidavid.springbootmall.dto.BuyItem;
import com.nidavid.springbootmall.dto.CreateOrderRequest;
import com.nidavid.springbootmall.model.Order;
import com.nidavid.springbootmall.model.OrderItem;
import com.nidavid.springbootmall.model.Product;
import com.nidavid.springbootmall.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;

    @Transactional //一次操作兩個資料庫，出錯強制rollback，避免一個成功一個失敗
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        int totalAmount = 0;
        List<OrderItem> orderItemList = new ArrayList<>();

        for (BuyItem buyItem : createOrderRequest.getBuyItemList()){
            Product product = productDao.getProductById(buyItem.getProductId());
            //計算價錢
            int amount = product.getPrice() * buyItem.getQuantity();
            totalAmount += amount;

            OrderItem orderItem = new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }


        Integer orderId = orderDao.createOrder(userId, totalAmount);

        orderDao.createOrderItems(orderId, orderItemList);

        return orderId;
    }

    @Override
    public Order getOrderById(Integer orderId) {
        Order order = orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList = orderDao.getOrderItemsByOrderId(orderId);

        order.setOrderItemList(orderItemList);

        return order;
    }
}
