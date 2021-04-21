package com.buct.employment.controller;

import com.buct.employment.controller.dto.CompanyReq;
import com.buct.employment.domain.Company;
import com.buct.employment.result.CodeMsg;
import com.buct.employment.result.Result;
import com.buct.employment.service.CompanyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
    public Result<Company> selectCompanyById(@RequestParam Long id){
        if (id <= 0) {
            return Result.error(400, "id should > 0");
        }
        try {
            Company company = companyService.selectCompanyById(id);
            log.info("查询企业id ：{}， 用户信息： {}", id, company);
            return Result.success(company);
        }
        catch (Throwable throwable) {
            log.error("There is something error: {}", throwable.getMessage());
            return Result.error(CodeMsg.SERVER_ERROR);
        }
    }
    //根据公司名找企业
    @GetMapping("/company")
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
    @GetMapping("/company")
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
    @GetMapping("/company")
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
}
