package com.buct.employment.utils;

import com.buct.employment.controller.dto.UserReq;
import com.buct.employment.domain.User;

import java.util.Date;

/**
 * @author JeffCar
 * @date 1/3/2021 - 9:16 PM
 */
public class UserServiceUtil {
    public static User setUser(UserReq userReq){
        Long id = userReq.getId();
        String avatar = userReq.getAvatar();
        Date birth = userReq.getBirth();
        String email = userReq.getEmail();
        String introduction = userReq.getIntroduction();
        String location = userReq.getLocation();
        String password = userReq.getPassword();
        String phoneNumber = userReq.getPhone_num();
        Boolean sex = userReq.getSex();
        String username = userReq.getUsername();
        String name = userReq.getName();

        User user = new User();
        if (id!=null){
            user.setId(id);
        }
        user.setAvatar(avatar);
        user.setBirth(birth);
        user.setEmail(email);
        user.setIntroduction(introduction);
        user.setLocation(location);
        user.setPassword(password);
        user.setPhone_num(phoneNumber);
        user.setSex(sex);
        user.setUsername(username);
        Long time = System.currentTimeMillis();
        user.setCreate_time(time);
        user.setName(name);

        return user;
    }
}
