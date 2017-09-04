package com.shoppingmall.service;

import com.shoppingmall.common.ServerResponse;
import com.shoppingmall.pojo.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by zhenizhui on 2017/6/5.
 */
public interface IUserService {
    ServerResponse<User> login(String username, String password);

    ServerResponse<String> register(User user);

    ServerResponse<String> checkValid(String str, String type);

    ServerResponse<String> checkUserName(String userName);

    ServerResponse<String> checkUserEmail(String email);

    ServerResponse selectQuestion(String userName);

    ServerResponse<String> checkAnswer(String userName, String question, String answer);

    ServerResponse<String> resetPassword(String userName, String passwordNew, String forgetToken);

    ServerResponse<String> resetPasswordWhenHasLogined(String passwordOld, String passwordNew, User user);

    ServerResponse<User> updateUserInfo(User user);

    ServerResponse<User> getUserInfo(Integer userId);

    ServerResponse checkAdminRole(User user);

    ServerResponse<User> getInformation(Integer userId);

    ServerResponse<User> updateInformation(User user);

    void getVerificationCode(HttpServletRequest req, HttpServletResponse resp);
}
