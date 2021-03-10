package com.buct.employment.domin;

import lombok.Data;

/**
 * @author JeffCar
 * @date 3/5/2021 - 5:51 PM
 */
@Data
public class Admin {
    // 自增主键
    private Long id;

    // 账号
    private String username;

    // 密码
    private String password;
}
