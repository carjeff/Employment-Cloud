package com.buct.employment.service.impl;

import com.buct.employment.controller.dto.CompanyReq;
import com.buct.employment.dao.CompanyMapper;
import com.buct.employment.domain.Company;
import com.buct.employment.service.CompanyService;
import com.buct.employment.utils.CompanyServiceUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author JeffCar
 * @date 4/1/2021 - 11:13 PM
 */
@Service
public class CompanyServiceImpl implements CompanyService {
    private final CompanyMapper companyMapper;

    public CompanyServiceImpl(CompanyMapper companyMapper) {
        this.companyMapper = companyMapper;
    }


    @Override
    public boolean insert(CompanyReq companyReq) {
        Company company = CompanyServiceUtil.setCompany(companyReq);
        long time = System.currentTimeMillis();
        company.setCreate_time(time);
        company.setUpdate_time(time);
        return companyMapper.insert(company) > 0;
    }

    @Override
    public boolean delete(Long id) {
        return companyMapper.delete(id)>0;
    }

    @Override
    public boolean update(CompanyReq companyReq) {
        Company company = CompanyServiceUtil.setCompany(companyReq);
        long time = System.currentTimeMillis();
        company.setUpdate_time(time);
        return companyMapper.update(company)>0 ;
    }

    @Override
    public Company selectCompanyById(Long id) {
        return companyMapper.selectCompanyById(id);
    }

    @Override
    public List<Company> selectAllCompanies() {
        return companyMapper.selectAllCompanies();
    }

    @Override
    public List<Company> selectCompanyByName(String company_name) {
        return companyMapper.selectCompanyByName(company_name);
    }

    @Override
    public List<Company> selectCompanyByNature(String company_nature) {
        return companyMapper.selectCompanyByNature(company_nature);
    }

    @Override
    public List<Company> selectCompanyByCity(String city) {
        return companyMapper.selectCompanyByCity(city);
    }
}
