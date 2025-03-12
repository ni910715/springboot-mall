package com.nidavid.springbootmall.dao;

import com.nidavid.springbootmall.dto.ProductQueryParams;
import com.nidavid.springbootmall.dto.ProductRequest;
import com.nidavid.springbootmall.model.Product;

import java.util.List;

public interface ProductDao {
    List<Product> getProducts(ProductQueryParams productQueryParams);

    Integer countProduct(ProductQueryParams productQueryParams);

    Product getProductById(Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct(Integer productId, ProductRequest productRequest);

    void deleteProductById(Integer productId);
}
