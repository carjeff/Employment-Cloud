package com.buct.employment.controller.dto;

import lombok.Data;

/**
 * @author JeffCar
 * @date 4/1/2021 - 11:14 PM
 */
@Data
public class CompanyReq {
    private Long company_id;
    private String company_name;
    private String company_scale;
    private String icon;
    private String company_nature;
    private String introduction;
    private String city;
    private String contact_person;
    private String contact_detail;
    private String website;
    private String email;
}
