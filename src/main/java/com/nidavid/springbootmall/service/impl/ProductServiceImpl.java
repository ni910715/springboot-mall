package com.nidavid.springbootmall.service.impl;

import com.nidavid.springbootmall.dao.ProductDao;
import com.nidavid.springbootmall.model.Product;
import com.nidavid.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
