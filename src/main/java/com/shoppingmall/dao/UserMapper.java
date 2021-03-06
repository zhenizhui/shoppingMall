package com.shoppingmall.dao;

import com.shoppingmall.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int checkUserName(String username);

    int checkEmail(String email);

    User selectLogin(@Param("username") String username, @Param("password")String password);

    String selectQuestionByUserName(String username);

    int checkAnswer(@Param("username")String username, @Param("question")String question, @Param("answer")String answer);

    int updatePasswordByUserName(@Param("username")String username, @Param("passwordNew")String passwordNew);

    int checkEmailByUserId(@Param(value = "email")String email, @Param(value = "userId")Integer userId);

    int checkPassword(@Param(value = "password")String password, @Param("userId")Integer userId);
}