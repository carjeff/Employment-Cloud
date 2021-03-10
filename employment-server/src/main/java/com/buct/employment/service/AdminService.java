package com.buct.employment.service;

/**
 * @author JeffCar
 * @date 3/6/2021 - 12:33 PM
 */
public interface AdminService {

    // 验证账号和密码
    boolean verifyPassword(String username, String password);
}
