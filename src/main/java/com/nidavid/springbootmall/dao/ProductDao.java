package com.nidavid.springbootmall.dao;

import com.nidavid.springbootmall.dto.ProductRequest;
import com.nidavid.springbootmall.model.Product;

public interface ProductDao {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
