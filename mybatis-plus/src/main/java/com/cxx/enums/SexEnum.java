package com.cxx.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;

/**
 * @author 陈喜喜
 * @date 2022-08-16 16:01
 * @EnumValue // 将注解所标识的属性的值存储到数据库中
 * 要在application.properties添加mybatis-plus.type-enums-package=com.cxx.enums配置
 */
public enum SexEnum {
    MALE(1,"男"),
    FEMALE(2,"女");

    @EnumValue // 将注解所标识的属性的值存储到数据库中
    private Integer sex;

    private String sexName;

    public Integer getSex() {
        return sex;
    }

    public String getSexName() {
        return sexName;
    }

    SexEnum(Integer sex, String sexName) {
        this.sex = sex;
        this.sexName = sexName;
    }
}
