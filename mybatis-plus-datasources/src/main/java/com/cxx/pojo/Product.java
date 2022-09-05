package com.cxx.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.Version;
import lombok.Data;

/**
 * @author 陈喜喜
 * @date 2022-08-16 20:56
 */
@Data
//@TableName("t_product")
public class Product {
    @TableId
    private Long id;
    private String name;
    private Integer price;
    @Version
    private Integer version;
}
