package com.buct.employment.domin;

import lombok.Data;

import java.util.Date;

/**
 * @author JeffCar
 * @date 3/10/2021 - 2:04 PM
 */
@Data
public class User {
    private Long id;

    private String username;

    private String password;

    //用户性别
    private int sex;
    //用户电话
    private String phone_num;
    //用户生日
    private Date birth;
    //邮箱
    private String email;
    //简介
    private String introduction;
    //地址
    private String location;
    //头像
    private String avatar;
    //创建时间
    private int create_time;
    //修改时间
    private int update_time;

}
