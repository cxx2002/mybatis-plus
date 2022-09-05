package com.cxx;

import com.cxx.mapper.UserMapper;
import com.cxx.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

import static java.lang.System.out;

@SpringBootTest
class MybatisPlusMybatisXApplicationTests {

    @Resource
    UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectAll();
        users.forEach(out::println);


    }

}
