package com.cxx;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxx.mapper.UserMapper;
import com.cxx.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class PluginsTests {
    @Resource
    private UserMapper mapper;

    @Test
    void testPage() {
        //条件构造器为null表示查所有
        Page<User> page = new Page<>(3,3);
        mapper.selectPage(page,null);
        System.out.println(page);
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
        //==>  Preparing: SELECT id,name,is_deleted,age,email FROM user WHERE is_deleted=0 LIMIT ?,?
        //==> Parameters: 6(Long), 3(Long)
    }

    @Test
    void testPageVo() {
        //或者可以直接用条件构造器实现selectPageVo
        Page<User> page = new Page<>(1,3);
        mapper.selectPageVo(page,20);
        System.out.println(page);
        System.out.println(page.getRecords());
        System.out.println(page.getPages());
        System.out.println(page.getTotal());
        System.out.println(page.hasNext());
        System.out.println(page.hasPrevious());
        //SELECT COUNT(*) AS total FROM user WHERE age > ?
        //==> Parameters: 20(Integer)
    }


}
