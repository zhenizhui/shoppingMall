package com.shoppingmall.controller.portal;

import com.shoppingmall.common.Const;
import com.shoppingmall.common.ResponseCode;
import com.shoppingmall.common.ServerResponse;
import com.shoppingmall.pojo.User;
import com.shoppingmall.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * Created by zhenizhui on 2017/6/5.
 */
@Controller
@RequestMapping("/user/")
public class UserController {
    @Autowired
    private IUserService iUserService;

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @param session
     * @return
     */
    @RequestMapping(value = "login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> login(String username, String password, HttpSession session) {
        ServerResponse<User> response = iUserService.login(username, password);

        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }

        return response;
    }

    /**
     * 用户登出
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "logout.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> logout(HttpSession session) {
        session.removeAttribute(Const.CURRENT_USER);
        return ServerResponse.createBySuccess();
    }

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "register.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> register(User user) {
        return iUserService.register(user);
    }

    /**
     * 检查填写的用户名是否有效
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "check_user_name.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> checkUserName(String userName) {
        return iUserService.checkUserName(userName);
    }

    /**
     * 检查填写的邮箱是否有效
     *
     * @param email
     * @return
     */
    @RequestMapping(value = "check_user_email.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> checkUserEmail(String email) {
        return iUserService.checkUserEmail(email);
    }

    /**
     * 用户名和邮箱校验
     *
     * @param str
     * @param type
     * @return
     */
    @RequestMapping(value = "check_valid.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> checkValid(String str, String type) {
        return iUserService.checkValid(str, type);
    }

    /**
     * 获取用户登录信息
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "get_user_logined_info.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> getUserLoginedInfo(HttpSession session) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user != null) {
            ServerResponse.createBySuccess(user);
        }
        return ServerResponse.createByErrorMessage("用户未登陆，无法获取用户信息");
    }

    /**
     * 密码提示问题的获取
     *
     * @param userName
     * @return
     */
    @RequestMapping(value = "forget_get_question.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> forgetGetQuestion(String userName) {
        return iUserService.selectQuestion(userName);
    }

    /**
     * 校验问题的答案是否正确
     *
     * @param userName
     * @param question
     * @param answer
     * @return
     */
    @RequestMapping(value = "check_question.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> checkAnswer(String userName, String question, String answer) {
        return iUserService.checkAnswer(userName, question, answer);
    }

    /**
     * 重置密码
     *
     * @param userName
     * @param passwordNew
     * @param forgetToken
     * @return
     */
    @RequestMapping(value = "reset_password.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> resetPassword(String userName, String passwordNew, String forgetToken) {
        return iUserService.resetPassword(userName, passwordNew, forgetToken);
    }

    /**
     * 登陆状态下重置密码
     *
     * @param session
     * @param passwordOld
     * @param paasswordNew
     * @return
     */
    @RequestMapping(value = "reset_password_when_has_login.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<String> resetPasswordWhenHasLogined(HttpSession session, String passwordOld, String paasswordNew) {
        User user = (User) session.getAttribute(Const.CURRENT_USER);
        if (user == null) {
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        return iUserService.resetPasswordWhenHasLogined(passwordOld, paasswordNew, user);
    }

    /**
     * 更新用户信息
     *
     * @param session
     * @param user
     * @return
     */
    @RequestMapping(value = "update_user_info.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> updateUserInfo(HttpSession session, User user) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        user.setId(currentUser.getId());
        user.setUsername(currentUser.getUsername());
        ServerResponse response = iUserService.updateUserInfo(user);
        if (response.isSuccess()) {
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

    /**
     * 获取用户信息
     *
     * @param session
     * @return
     */
    @RequestMapping(value = "get_user_info.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> getUserInfo(HttpSession session) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(), "hello");
        }
        return iUserService.getUserInfo(currentUser.getId());
    }

    @RequestMapping(value = "get_information.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> get_information(HttpSession session) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorCodeMsg(ResponseCode.NEED_LOGIN.getCode(), "未登录,需要强制登录status=10");
        }
        return iUserService.getInformation(currentUser.getId());
    }

    /**
     * 更新个人信息
     *
     * @param session
     * @param user
     * @return
     */
    @RequestMapping(value = "update_information.do", method = RequestMethod.POST)
    @ResponseBody
    public ServerResponse<User> update_information(HttpSession session, User user) {
        User currentUser = (User) session.getAttribute(Const.CURRENT_USER);
        if (currentUser == null) {
            return ServerResponse.createByErrorMessage("用户未登录");
        }
        user.setId(currentUser.getId());
        user.setUsername(currentUser.getUsername());
        ServerResponse<User> response = iUserService.updateInformation(user);
        if (response.isSuccess()) {
            response.getData().setUsername(currentUser.getUsername());
            session.setAttribute(Const.CURRENT_USER, response.getData());
        }
        return response;
    }

}
