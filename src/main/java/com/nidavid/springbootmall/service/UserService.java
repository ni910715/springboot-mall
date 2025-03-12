package com.nidavid.springbootmall.service;

import com.nidavid.springbootmall.dto.UserRegisterRequest;
import com.nidavid.springbootmall.model.User;

public interface UserService {
    Integer register(UserRegisterRequest userRegisterRequest);

    User getUserById(Integer userId);
}
