package com.cxx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxx.mapper.ProductMapper;
import com.cxx.pojo.Product;
import com.cxx.service.ProductService;
import org.springframework.stereotype.Service;

/**
 * @author 陈喜喜
 * @date 2022-08-16 21:11
 */
@DS("slave_1")
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {
}
