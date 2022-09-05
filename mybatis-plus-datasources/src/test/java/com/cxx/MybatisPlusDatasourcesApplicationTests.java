package com.cxx;

import com.cxx.mapper.UserMapper;
import com.cxx.service.ProductService;
import com.cxx.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class MybatisPlusDatasourcesApplicationTests {
    @Resource
    UserService userService;
    @Resource
    ProductService productService;
    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {
        System.out.println(userService.getById(1));
        System.out.println(productService.getById(1));
        System.out.println(userMapper.selectById(1));
    }

}
