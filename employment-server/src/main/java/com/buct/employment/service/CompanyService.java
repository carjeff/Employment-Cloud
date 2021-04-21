package com.buct.employment.service;

import com.buct.employment.controller.dto.CompanyReq;
import com.buct.employment.domain.Company;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JeffCar
 * @date 4/1/2021 - 11:01 PM
 */
public interface CompanyService {
    //添加企业
    boolean insert(CompanyReq companyReq);

    //根据id删除企业
    boolean delete(Long id);

    //修改企业
    boolean update(CompanyReq companyReq);

    //根据主键查询用户
    Company selectCompanyById(Long id);

    // 查询所有用户
    List<Company> selectAllCompanies();

    // 根据企业名字模糊查询
    List<Company> selectCompanyByName(String company_name);

    //根据企业性质查询
    List<Company> selectCompanyByNature(String company_nature);

    //根据城市查询
    List<Company> selectCompanyByCity(String city);
}
