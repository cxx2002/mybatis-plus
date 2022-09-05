package com.cxx.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.cxx.enums.SexEnum;

import java.util.Objects;

/**
 * @author 陈喜喜
 * @date 2022-08-15 10:10
 * @TableName("user")  指定实体类与数据库对应的表名
 * @TableId  指定数据库表的注解与实体类的字段对应,这样不写主键的话，mybatisplus会默认雪花算法生成一个主键赋给主键
 * @TableId  value属性指定这个实体类字段对应是数据库那个主键的名字
 * @TableId  type属性是指定mybatisplus默认是雪花算法还是自增id等等(AUTO(0)的前提条件是数据库主键字段也是自增)
 *                  AUTO(0),NONE(1),INPUT(2),ASSIGN_ID(3),ASSIGN_UUID(4);
 * mybatisplus  会默认将实体类的驼峰对应成数据库的下划线  private Integer isDeleted => is_deleted
 * @TableField("name")  如果数据库的列名为username,那么要在private String name;加注解@TableField("username")
 * @TableLogic  逻辑删除字段注解
 * @Version  标识乐观锁版本号字段
 */
@TableName("user")
public class User {
    @TableId(value = "id",type = IdType.ASSIGN_ID)
    private Long id;

    @TableField("name")
    private String name;

    @TableLogic
    private Integer isDeleted;

    private SexEnum sex;

    private Integer age;

    private String email;
    public User(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(name, user.name) && Objects.equals(isDeleted, user.isDeleted) && sex == user.sex && Objects.equals(age, user.age) && Objects.equals(email, user.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, isDeleted, sex, age, email);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isDeleted=" + isDeleted +
                ", sex=" + sex +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

    public SexEnum getSex() {
        return sex;
    }

    public void setSex(SexEnum sex) {
        this.sex = sex;
    }

    public User(String name, SexEnum sex) {
        this.name = name;
        this.sex = sex;
    }

    public User(String name, SexEnum sex, Integer age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public User(Long id, String name, Integer isDeleted, SexEnum sex, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.isDeleted = isDeleted;
        this.sex = sex;
        this.age = age;
        this.email = email;
    }

    public User(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User() {
    }

    public User(Long id, String name, Integer age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

}
