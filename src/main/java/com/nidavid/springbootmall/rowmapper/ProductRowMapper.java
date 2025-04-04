package com.nidavid.springbootmall.rowmapper;

import com.nidavid.springbootmall.constant.ProductCategory;
import com.nidavid.springbootmall.model.Product;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;

public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet rs, int rowNum) throws SQLException {
        Product product = new Product();

        product.setProductId(rs.getInt("product_id"));
        product.setProductName(rs.getString("product_name"));

        //從資料庫取出的 String 類型與我們預先定義好的 Enum 做轉換
        String categoryStr = rs.getString("category");
        ProductCategory category = ProductCategory.valueOf(categoryStr);
        product.setCategory(category);

        product.setImageUrl(rs.getString("image_url"));
        product.setPrice(rs.getInt("price"));
        product.setStock(rs.getInt("stock"));
        product.setDescription(rs.getString("description"));
        product.setCreatedTime(rs.getTimestamp("created_date"));
        product.setLastModifiedDate(rs.getTimestamp("last_modified_date"));

        //折扣價，用 getObject，避免 null 變 0 的問題
        Integer discountPrice = rs.getObject("discount_price", Integer.class);
        product.setDiscountPrice(discountPrice);

        //開始時間 / 結束時間，getTimestamp()自動處理 null
        Timestamp startTimestamp = rs.getTimestamp("start_time");
        if (startTimestamp != null) {
            product.setStartTime(new Date(startTimestamp.getTime()));
        }

        Timestamp endTimestamp = rs.getTimestamp("end_time");
        if (endTimestamp != null) {
            product.setEndTime(new Date(endTimestamp.getTime()));
        }


        return product;
    }
}
