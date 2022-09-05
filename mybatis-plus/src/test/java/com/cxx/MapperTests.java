package com.cxx;

import com.cxx.mapper.UserMapper;
import com.cxx.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class MapperTests {
    @Resource
    private UserMapper mapper;

    @Test
    void contextLoads() {
        List<User> users = mapper.selectList(null);
        users.forEach(user -> System.out.println(user));
        Map<String, Object> map = mapper.selectMapById(1L);
        System.out.println(map);
    }

    @Test
    void contextLoads2() {
        //==>  Preparing: INSERT INTO user ( id, name, age, email ) VALUES ( ?, ?, ?, ? )
        //==> Parameters: 1559010614872240129(Long), 张三(String), 23(Integer), zhangsan@123.com(String)
        User user = new User("张三", 23, "zhangsan@123.com");
        int result = mapper.insert(user);
        System.out.println("result: " + result);
        System.out.println("user: " + user);
    }

    @Test
    void contextLoads3() {
        //根据id删除用户，因为太长了，后面加个L转为Long类型
        //mapper.deleteById(1559010614872240129L);

        HashMap<String, Object> map = new HashMap<>();
        //map.put("name", "张三");
        map.put("age", 23);
        //表示删除满足name=张三并且age=23条件的用户
        //==>  Preparing: DELETE FROM user WHERE name = ? AND age = ?
        //==> Parameters: 张三(String), 23(Integer)
        mapper.deleteByMap(map);

        //根据id批量删除用户
        //List<Long> list = Arrays.asList(1L, 2L,3L);
        //mapper.deleteBatchIds(list);
        //==>  Preparing: DELETE FROM user WHERE id IN (?,?,?)
        //==> Parameters: 1(Long),2(Long),3(Long)
    }

    @Test
    void contextLoads4() {
        mapper.updateById(new User(4L,"李四",22,"lisi@123.com"));
        //==>  Preparing: UPDATE user SET name=?, age=?, email=? WHERE id=?
        //==> Parameters: 李四(String), 22(Integer), lisi@123.com(String), 4(Long)
    }

    @Test
    void contextLoads5() {
        //System.out.println(mapper.selectById(1L));

        /*List<Long> list = Arrays.asList(1L, 2L, 3L);
        List<User> users = mapper.selectBatchIds(list);
        users.forEach( System.out::println);*/
        //==>  Preparing: SELECT id,name,age,email FROM user WHERE id IN ( ? , ? , ? )
        //==> Parameters: 1(Long), 2(Long), 3(Long)

        Map<String, Object> map = new HashMap<>( );
        map.put("name", "Jack");
        map.put("age", 20);
        List<User> users = mapper.selectByMap(map);
        users.forEach( System.out::println);
        //==>  Preparing: SELECT id,name,age,email FROM user WHERE name = ? AND age = ?
        //==> Parameters: Jack(String), 20(Integer)
    }
}
