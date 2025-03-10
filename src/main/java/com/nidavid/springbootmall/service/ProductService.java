package com.nidavid.springbootmall.service;

import com.nidavid.springbootmall.dto.ProductRequest;
import com.nidavid.springbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);
}
