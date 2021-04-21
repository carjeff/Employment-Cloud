package com.buct.music.utils;

import com.buct.music.controller.dto.UserReq;
import com.buct.music.domin.User;

import java.util.Date;

/**
 * @author JeffCar
 * @date 1/3/2021 - 9:16 PM
 */
public class UserServiceUtil {
    public static User setUser(UserReq userReq){
        Long id = userReq.getId();
        String avator = userReq.getAvator();
        Date birth = userReq.getBirth();
        String email = userReq.getEmail();
        String introduction = userReq.getIntroduction();
        String location = userReq.getLocation();
        String password = userReq.getPassword();
        String phoneNumber = userReq.getPhoneNumber();
        Boolean sex = userReq.getSex();
        String username = userReq.getUsername();

        User user = new User();
        if (id!=null){
            user.setId(id);
        }
        user.setAvator(avator);
        user.setBirth(birth);
        user.setEmail(email);
        user.setIntroduction(introduction);
        user.setLocation(location);
        user.setPassword(password);
        user.setPhoneNumber(phoneNumber);
        user.setSex(sex);
        user.setUsername(username);

        return user;
    }
}
