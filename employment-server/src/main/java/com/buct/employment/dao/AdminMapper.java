package com.buct.employment.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @author JeffCar
 * @date 3/6/2021 - 12:09 PM
 */
@Mapper
@Repository
public interface AdminMapper {
    /**
     * 验证密码是否正确
     * @param username  账号
     * @param password  密码
     * @return 查询结果个数
     */
    int verifyAdmin(@Param("username") String username, @Param("password") String password);
}
