package com.buct.employment.service.impl;

import com.buct.employment.controller.dto.UserReq;
import com.buct.employment.dao.UserMapper;
import com.buct.employment.domain.User;
import com.buct.employment.service.UserService;
import com.buct.employment.utils.UserServiceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JeffCar
 * @date 3/11/2021 - 5:41 PM
 */
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {this.userMapper = userMapper;}
    @Override
    public boolean verifyPassword(String username, String password) {
        return userMapper.verifyPassword(username, password) > 0;
    }

    @Override
    public User selectUserById(Long id) {
        return userMapper.selectUserById(id);
    }

    @Override
    public boolean insert(UserReq userReq) {
        User user = UserServiceUtil.setUser(userReq);
        long time = System.currentTimeMillis();
        user.setUpdate_time(time);
        return userMapper.insert(user) > 0;
    }

    @Override
    public boolean delete(Long id) {
        return userMapper.delete(id)>0;
    }

    @Override
    public boolean update(UserReq userReq) {
        User user = UserServiceUtil.setUser(userReq);
        long time = System.currentTimeMillis();
        user.setUpdate_time(time);
        return userMapper.update(user)>0;
    }

    @Override
    public List<User> selectAllUsers() {
        return userMapper.selectAllUsers();
    }

    @Override
    public List<User> selectUserByName(String username) {
        return userMapper.selectUserByName(username);
    }
}
