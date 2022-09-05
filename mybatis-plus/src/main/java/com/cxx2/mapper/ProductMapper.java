package com.cxx2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxx2.entity.Product;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author cxx
 * @since 2022-08-16
 */
public interface ProductMapper extends BaseMapper<Product> {

    int insertSelective(Product product);

}
