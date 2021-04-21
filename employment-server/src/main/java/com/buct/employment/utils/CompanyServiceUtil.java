package com.buct.employment.utils;

import com.buct.employment.controller.dto.CompanyReq;
import com.buct.employment.domain.Company;

/**
 * @author JeffCar
 * @date 4/1/2021 - 11:29 PM
 */
public class CompanyServiceUtil {
    public static Company setCompany(CompanyReq companyReq) {
        Company company = new Company();
        if (company.getCompany_id() != null){
            company.setCompany_id(companyReq.getCompany_id());
        }
        company.setCompany_name(companyReq.getCompany_name());
        company.setCity(companyReq.getCity());
        company.setCompany_nature(companyReq.getCompany_nature());
        company.setCompany_scale(companyReq.getCompany_scale());
        company.setContact_detail(companyReq.getContact_detail());
        company.setIntroduction(companyReq.getIntroduction());
        company.setEmail(companyReq.getEmail());
        company.setIcon(companyReq.getIcon());
        company.setContact_person(companyReq.getContact_person());
        company.setWebsite(companyReq.getWebsite());
        return company;
    }
}
