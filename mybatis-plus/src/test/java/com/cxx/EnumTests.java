package com.cxx;

import com.cxx.enums.SexEnum;
import com.cxx.mapper.UserMapper;
import com.cxx.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class EnumTests {
    @Resource
    private UserMapper mapper;

    @Test
    void contextLoads() {
        int result = mapper.insert(new User("哈哈", SexEnum.MALE, 28));
        System.out.println("result: " + result);
    }

}
