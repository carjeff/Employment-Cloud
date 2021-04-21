package com.buct.employment.dao;

import com.buct.employment.domain.Company;
import com.buct.employment.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author JeffCar
 * @date 4/1/2021 - 9:08 PM
 */
@Mapper
@Repository
public interface CompanyMapper {
    //添加企业
    int insert(Company company);

    //根据id删除企业
    int delete(Long id);

    //修改企业
    int update(Company company);

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
