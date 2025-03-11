package com.nidavid.springbootmall.service;

import com.nidavid.springbootmall.constant.ProductCategory;
import com.nidavid.springbootmall.dto.ProductRequest;
import com.nidavid.springbootmall.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getProducts(ProductCategory category, String search);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);

}
