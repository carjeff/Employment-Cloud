package com.buct.employment.service;

import com.buct.employment.controller.dto.UserReq;
import com.buct.employment.domain.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JeffCar
 * @date 3/11/2021 - 5:40 PM
 */
public interface UserService {

    //验证登录
    boolean verifyPassword(String username, String password);
    //根据id查找用户
    User selectUserById(Long id);

    //添加用户
    boolean insert(UserReq userReq);

    //删除用户
    boolean delete(Long id);

    //更新用户
    boolean update(UserReq userReq);

    //查找所有用户
    List<User> selectAllUsers();

    //根据username模糊查找用户
    List<User> selectUserByName(String username);
}
