package com.buct.employment.dao;

import com.buct.employment.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author JeffCar
 * @date 3/10/2021 - 2:07 PM
 */
@Mapper
@Repository
public interface UserMapper {
    //验证登录
    int verifyPassword(@Param("username") String username, @Param("password") String password);
    //添加用户
    int insert(User user);

    //根据id删除用户
    int delete(Long id);

    //修改用户
    int update(User user);

    //根据主键查询用户
    User selectUserById(Long id);

    // 查询所有用户
    List<User> selectAllUsers();

    // 根据用户名字模糊查询
    List<User> selectUserByName(String username);
}
