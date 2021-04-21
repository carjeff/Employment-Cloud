package com.buct.employment.domain;

import lombok.Data;

import java.io.Serializable;

/**
 * @author JeffCar
 * @date 4/1/2021 - 9:03 PM
 */
@Data
public class Company implements Serializable {
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
    private Long create_time;
    private Long update_time;
}
