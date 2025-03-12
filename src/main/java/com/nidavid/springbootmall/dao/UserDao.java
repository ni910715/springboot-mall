package com.nidavid.springbootmall.dao;

import com.nidavid.springbootmall.dto.UserRegisterRequest;
import com.nidavid.springbootmall.model.User;

public interface UserDao {
    Integer createUser(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);

    User getUserByEmail(String email);
}
