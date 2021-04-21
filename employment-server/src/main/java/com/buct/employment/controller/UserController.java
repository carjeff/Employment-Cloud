package com.buct.employment.controller;

import com.buct.employment.controller.dto.UserReq;
import com.buct.employment.dao.UserMapper;
import com.buct.employment.domain.User;
import com.buct.employment.enums.FilePathEnum;
import com.buct.employment.result.CodeMsg;
import com.buct.employment.result.Result;
import com.buct.employment.service.UserService;
import com.sun.org.apache.bcel.internal.classfile.Code;
import lombok.extern.slf4j.Slf4j;
import org.omg.Messaging.SYNC_WITH_TRANSPORT;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author JeffCar
 * @date 3/11/2021 - 5:45 PM
 */
@RestController
@RequestMapping("/admin")
@Slf4j
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    /**
     * 验证用户登录
     *
     * @param userReq
     * @return
     */
    @PostMapping("/login/login/status")
    public Result<CodeMsg> loginStatus(@RequestBody UserReq userReq) {
        try {
            boolean flag = userService.verifyPassword(userReq.getUsername(), userReq.getPassword());
            log.info("登录用户信息为: username: {}, password: {}", userReq.getUsername(), userReq.getPassword());
            if (flag) {
                return Result.success(CodeMsg.LOGIN_SUCCESS);
            } else {
                return Result.error(CodeMsg.LOGIN_FAILURE);
            }
        } catch (Throwable throwable) {
            log.error("There is something error: {}", throwable.getMessage());
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    /**
     * 通过主键id查找用户
     * @param id
     * @return
     */
    @GetMapping("/user")
    public Result<User> getByPrimaryKey(@RequestParam Long id){
        if (id <= 0) {
            return Result.error(400, "id should > 0");
        }
        try {
            User user = userService.selectUserById(id);
            log.info("查询用户id ：{}， 用户信息： {}", id, user);
            return Result.success(user);
        }
        catch (Throwable throwable) {
            log.error("There is something error: {}", throwable.getMessage());
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    /**
     * 添加用户
     * @param userReq
     * @return
     */
    @PostMapping("/user")
    public Result<CodeMsg> addUser(@RequestBody UserReq userReq) {
        try {
            boolean flag = userService.insert(userReq);
            log.info("增加用户参数： {}", userReq);
            if (flag) {
                return Result.success(CodeMsg.SUCCESS);
            } else {
                return Result.error(CodeMsg.FAILURE);
            }
        } catch (Throwable throwable) {
            log.error("There is something error : {}", throwable.getMessage());
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    /**
     * 修改用户
     * @param userReq
     * @return
     */
    @PutMapping("/user")
    public Result<CodeMsg> updateUser(@RequestBody UserReq userReq) {
        try {
            boolean flag = userService.update(userReq);
            if (flag) {
                log.info("修改用户参数： {}", userReq);
                return Result.success(CodeMsg.SUCCESS);
            } else {
                return Result.error(CodeMsg.FAILURE);
            }
        } catch (Throwable throwable) {
            log.error("There is something error : {}", throwable.getMessage());
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    /**
     * 删除用户id
     * @param id
     * @return
     */
    @DeleteMapping("/user")
    public Result<CodeMsg> deleteUser(@RequestParam Long id) {
        if (id <= 0) {
            return Result.error(400, "id should > 0 ");
        }
        try {
            boolean flag = userService.delete(id);
            if (flag) {
                return Result.success(CodeMsg.SUCCESS);
            } else {
                return Result.error(CodeMsg.FAILURE);
            }
        } catch (Throwable throwable) {
            log.error("There is something error: {}", throwable.getMessage());
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    /**
     * 查询所有用户
     * @return
     */
    @GetMapping("/users")
    public Result<List<User>> selectAllUsers() {
        try {
            List<User> users = userService.selectAllUsers();
            log.info("查询用户: {}", users);
            return Result.success(users);
        } catch (Throwable throwable) {
            log.error("There is something error: {}", throwable.getMessage());
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    /**
     * 根据用户名查询
     * @param username
     * @return
     */
    @GetMapping("/users/username")
    public Result<List<User>> selectUserByName(@RequestParam String username) {
        try {
            List<User> users = userService.selectUserByName(username);
            log.info("根据用户名查询用户：{}", users);
            return Result.success(users);
        } catch (Throwable throwable){
            log.error("There is something error: {}", throwable.getMessage());
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }

    @PostMapping("user/updatePic")
    public Result<CodeMsg> updateUserPic(@RequestParam("file") MultipartFile picture, @RequestParam Long id){
        if (picture.isEmpty()){
            return Result.error(400,"picture upload failed");
        }
        String type = picture.getContentType();
        if (type != null && !type.equals("image/jpeg")&& !type.equals("image/png")) {
            return Result.error(400, "the type of picture should be 'jpg/jpeg/png' !" );
        }

        long size = picture.getSize();
        if (size /1024/1024 > 2){
            return Result.error(400, "the size of picture should be < 2M !");
        }

        if (id <=0 ){
            return Result.error(400, "id should > 0 !" );
        }

        //文件名 = 当前时间毫秒 + 原文件名
        String newFileName = System.currentTimeMillis() + picture.getOriginalFilename();

        //文件存储路径 —— 文件夹（绝对路径）
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator")
                + FilePathEnum.IMG_PATH.getPath() + System.getProperty("file.separator") + FilePathEnum.USER_AVATAR.getPath();
        File file = new File(filePath);
        if (!file.exists() && !file.isDirectory()) {
            log.info("file directory is not exits");
            boolean flag = file.mkdirs();
            if (flag) {
                log.info("create a directory");
            } else {
                log.info("failed to create a directory");
            }
        }

        //实际文件存储地址
        File fileToPath = new File(filePath + System.getProperty("file.separator") + newFileName);

        //存储到数据库的相对文件路径
        String databaseFilePath = FilePathEnum.USER_AVATAR_PATH.getPath() + newFileName;

        try{
            //将文件存储到磁盘
            picture.transferTo(fileToPath);
            UserReq userReq = new UserReq();
            userReq.setId(id);
            userReq.setAvatar(databaseFilePath);
            boolean flag = userService.update(userReq);
            log.info("文件更新信息： id: {}, 文件在磁盘位置： {}, 存储到数据库中信息: {}", id, fileToPath, databaseFilePath);
            if (flag) {
                return Result.success(CodeMsg.SUCCESS);
            } else {
                return Result.error(CodeMsg.FAILURE);
            }
        } catch (IOException e) {
            e.printStackTrace();
            log.error("上传文件失败，异常信息: {}", e.getMessage());
            return Result.error(CodeMsg.SERVER_ERROR);
        }



    }








}
