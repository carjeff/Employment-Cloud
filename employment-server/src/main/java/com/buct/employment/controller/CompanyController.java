package com.buct.employment.controller;

import com.buct.employment.controller.dto.CompanyReq;
import com.buct.employment.controller.dto.UserReq;
import com.buct.employment.domain.Company;
import com.buct.employment.enums.FilePathEnum;
import com.buct.employment.result.CodeMsg;
import com.buct.employment.result.Result;
import com.buct.employment.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @author JeffCar
 * @date 4/20/2021 - 9:18 PM
 */
@RestController
@RequestMapping("/admin")
@Slf4j
public class CompanyController {
    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    //添加企业
    @PostMapping("/company")
    public Result<CodeMsg> addCompany(@RequestBody CompanyReq companyReq){
        try {
            boolean flag = companyService.insert(companyReq);
            log.info("增加企业参数： {}", companyReq);
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
    //修改企业
    @PutMapping("/company")
    public Result<CodeMsg> updateCompany(@RequestBody CompanyReq companyReq){
        try {
            boolean flag = companyService.update(companyReq);
            if (flag) {
                log.info("修改企业参数： {}", companyReq);
                return Result.success(CodeMsg.SUCCESS);
            } else {
                return Result.error(CodeMsg.FAILURE);
            }
        } catch (Throwable throwable) {
            log.error("There is something error : {}", throwable.getMessage());
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
    //删除企业
    @DeleteMapping("/company")
    public Result<CodeMsg> deleteCompany(@RequestParam Long id){
        if (id <= 0) {
            return Result.error(400, "id should > 0 ");
        }
        try {
            boolean flag = companyService.delete(id);
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
    //根据id找企业
    @GetMapping("/company")
    public Result<Company> selectCompanyById(@RequestParam Long company_id){
        if (company_id <= 0) {
            return Result.error(400, "company_id should > 0");
        }
        try {
            Company company = companyService.selectCompanyById(company_id);
            log.info("查询企业id ：{}， 用户信息： {}", company_id, company);
            return Result.success(company);
        }
        catch (Throwable throwable) {
            log.error("There is something error: {}", throwable.getMessage());
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
    //根据公司名找企业
    @GetMapping("/company/name")
    public Result<List<Company>> selectCompanyByName(@RequestParam String name){
        try {
            List<Company> companies = companyService.selectCompanyByName(name);
            log.info("根据企业名名查询企业：{}", companies);
            return Result.success(companies);
        } catch (Throwable throwable){
            log.error("There is something error: {}", throwable.getMessage());
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
    //查找所有企业
    @GetMapping("/companies")
    public Result<List<Company>> selectAllCompanies(){
        try {
            List<Company> companies = companyService.selectAllCompanies();
            log.info("查询企业: {}", companies);
            return Result.success(companies);
        } catch (Throwable throwable) {
            log.error("There is something error: {}", throwable.getMessage());
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
    //根据公司性质找企业
    @GetMapping("/company/nature")
    public Result<List<Company>> selectCompanyByNature(@RequestParam String nature){
        try {
            List<Company> companies = companyService.selectCompanyByNature(nature);
            log.info("查询企业: {}", companies);
            return Result.success(companies);
        } catch (Throwable throwable) {
            log.error("There is something error: {}", throwable.getMessage());
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
    //根据地点找企业
    @GetMapping("/company/city")
    public Result<List<Company>> selectCompanyByCity(@RequestParam String city){
        try {
            List<Company> companies = companyService.selectCompanyByCity(city);
            log.info("查询企业: {}", companies);
            return Result.success(companies);
        } catch (Throwable throwable) {
            log.error("There is something error: {}", throwable.getMessage());
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
    @PostMapping("company/updatePic")
    public Result<CodeMsg> updateUserPic(@RequestParam("file") MultipartFile picture, @RequestParam Long id) {
        if (picture.isEmpty()) {
            return Result.error(400, "picture upload failed");
        }
        String type = picture.getContentType();
        if (type != null && !type.equals("image/jpeg") && !type.equals("image/png")) {
            return Result.error(400, "the type of picture should be 'jpg/jpeg/png' !");
        }

        long size = picture.getSize();
        if (size / 1024 / 1024 > 2) {
            return Result.error(400, "the size of picture should be < 2M !");
        }

        if (id <= 0) {
            return Result.error(400, "id should > 0 !");
        }

        //文件名 = 当前时间毫秒 + 原文件名
        String newFileName = System.currentTimeMillis() + picture.getOriginalFilename();

        //文件存储路径 —— 文件夹（绝对路径）
        String filePath = System.getProperty("user.dir") + System.getProperty("file.separator")
                + FilePathEnum.IMG_PATH.getPath() + System.getProperty("file.separator") + FilePathEnum.COMPANY_ICON.getPath();
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
        String databaseFilePath = FilePathEnum.COMPANY_ICON_PATH.getPath() + newFileName;

        try {
            //将文件存储到磁盘
            picture.transferTo(fileToPath);
            CompanyReq companyReq = new CompanyReq();
            companyReq.setCompany_id(id);
            companyReq.setIcon(databaseFilePath);
            boolean flag = companyService.update(companyReq);
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

