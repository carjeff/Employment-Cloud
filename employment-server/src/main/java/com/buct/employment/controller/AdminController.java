package com.buct.employment.controller;

import com.buct.employment.controller.dto.AdminReq;
import com.buct.employment.result.CodeMsg;
import com.buct.employment.result.Result;
import com.buct.employment.service.AdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author JeffCar
 * @date 3/6/2021 - 1:07 PM
 */
@RestController
@RequestMapping("/admin")
@Slf4j
public class AdminController {
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @PostMapping("/login/status")
    public Result<CodeMsg> loginStatus(@RequestBody AdminReq adminReq) {
        try {
            boolean flag = adminService.verifyPassword(adminReq.getUsername(), adminReq.getPassword());
            log.info("登录管理员信息为：username: {}, password: {}", adminReq.getUsername(), adminReq.getPassword());
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
}
