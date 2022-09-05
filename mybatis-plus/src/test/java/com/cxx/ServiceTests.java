package com.cxx;

import com.cxx.pojo.User;
import com.cxx.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class ServiceTests {
    @Resource
    private UserService userService;

    @Test
    public void testGetCount(){
        long count = userService.count();
        System.out.println("总记录数："+count);
    }

    @Test
    public void testInsertMore(){
        //批量添加
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(new User("abc"+i,20+i));
        }
        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }

}
