package com.nidavid.springbootmall.dao;

import com.nidavid.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);
}
