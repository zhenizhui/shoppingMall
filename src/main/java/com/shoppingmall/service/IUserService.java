package com.shoppingmall.service;


import com.shoppingmall.common.ServerResponse;
import com.shoppingmall.pojo.User;

/**
 * Created by zhenizhui on 2017/6/5.
 */
public interface IUserService {
    ServerResponse<User> login(String name, String password);
}
