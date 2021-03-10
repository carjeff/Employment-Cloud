package com.buct.employment.enums;

/**
 * 性别枚举类
 * @author Zhang JunFeng
 * @date 2021/1/2 17:44
 */
public enum SexEnum {
    /**
     * MALE: 男；DEMALE: 女；GROUP: 组合
     */
    MALE(1),
    FEMALE(0),
    GROUP(2);

    private final Integer state;

    SexEnum(Integer state) {
        this.state = state;
    }

    public Integer getState() {
        return this.state;
    }
}
