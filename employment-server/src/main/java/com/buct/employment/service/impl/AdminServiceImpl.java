package com.buct.employment.service.impl;

import com.buct.employment.dao.AdminMapper;
import com.buct.employment.service.AdminService;
import org.springframework.stereotype.Service;

/**
 * @author JeffCar
 * @date 3/6/2021 - 1:02 PM
 */
@Service
public class AdminServiceImpl implements AdminService {
    private final AdminMapper adminMapper;

    public AdminServiceImpl(AdminMapper adminMapper) {
        this.adminMapper = adminMapper;
    }

    /**
     *
     * @param username  账号
     * @param password  密码
     * @return  存在：true，否则：false
     */
    @Override
    public boolean verifyPassword(String username, String password) {
        return adminMapper.verifyAdmin(username, password) > 0;
    }
}
