package com.cxx2.service.impl;

import com.cxx2.entity.Product;
import com.cxx2.mapper.ProductMapper;
import com.cxx2.service.IProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cxx
 * @since 2022-08-16
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
