package com.nidavid.springbootmall.service.impl;

import com.nidavid.springbootmall.dao.ProductDao;
import com.nidavid.springbootmall.dto.ProductQueryParams;
import com.nidavid.springbootmall.dto.ProductRequest;
import com.nidavid.springbootmall.model.Product;
import com.nidavid.springbootmall.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDao productDao;

    @Override
    public Integer countProduct(ProductQueryParams productQueryParams) {
        return productDao.countProduct(productQueryParams);
    }

    @Override
    public List<Product> getProducts(ProductQueryParams productQueryParams) {
        return productDao.getProducts(productQueryParams);
    }

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }

    @Override
    @Transactional
    public Integer createProduct(ProductRequest productRequest) {
        Integer productId = productDao.createProduct(productRequest);

        if (productRequest.getDiscountPrice() != null && productRequest.getStartTime() != null && productRequest.getEndTime() != null) {
            productDao.createDiscount(productId, productRequest);
        }

        return productId;
    }

    @Override
    @Transactional
    public void updateProduct(Integer productId, ProductRequest productRequest) {
        productDao.updateProduct(productId, productRequest);

        if (productRequest.getDiscountPrice() != null && productRequest.getStartTime() != null && productRequest.getEndTime() != null) {
            if (productDao.hasDiscount(productId)) {
                productDao.updateDiscount(productId, productRequest);
            } else {
                productDao.createDiscount(productId, productRequest);
            }
        }
    }

    @Override
    public void deleteProductById(Integer productId) {
        productDao.deleteProductById(productId);
    }
}
