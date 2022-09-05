package com.cxx.pojo;

import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.Data;

/**
 * @author 陈喜喜
 * @date 2022-08-16 20:56
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
    private Integer sex;
    @TableLogic
    private Integer isDeleted;
}
