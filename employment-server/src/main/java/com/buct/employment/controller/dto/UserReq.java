package com.buct.employment.controller.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author JeffCar
 * @date 3/11/2021 - 5:45 PM
 */
@Data
public class UserReq implements Serializable {
    //自增主键
    private Long id;

    //用户名
    private String username;

    //用户姓名
    private String name;

    //用户密码
    private String password;

    //用户性别 1 : 男  0 ：女
    private Boolean sex;

    //电话
    private String phone_num;

    //邮箱
    private String email;

    //生日
    private Date birth;

    //签名
    private String introduction;

    //地址
    private String location;

    //头像
    private String avatar;
}
