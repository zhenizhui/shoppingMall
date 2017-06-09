package com.shoppingmall.service;


import com.shoppingmall.common.ServerResponse;
import com.shoppingmall.pojo.User;

/**
 * Created by zhenizhui on 2017/6/5.
 */
public interface IUserService {
    ServerResponse<User> login(String name, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String str, String type);

    ServerResponse selectQuestion(String userName);

    ServerResponse<String> checkAnswer(String userName, String question, String answer);

    ServerResponse<String> resetPassword(String userName, String passwordNew, String forgetToken);

    ServerResponse<String> resetPasswordWhenHasLogined(String passwordOld, String passwordNew, User user);

    ServerResponse<User> updateUserInfo(User user);

    ServerResponse<User> getUserInfo(Integer userId);

    ServerResponse checkAdminRole(User user);
}
