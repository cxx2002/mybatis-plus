package com.cxx;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.cxx.mapper.UserMapper;
import com.cxx.pojo.User;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * 注意：wrapper里的方法的column都是写的是数据库的列名
 */

@SpringBootTest
class WrapperTest {
   @Resource
   private UserMapper mapper;

   @Test
    public void test1(){
       //查询用户名包含a，age在20~30，email不为空的用户信息
       //gt为大于等于，le为小于等于
       QueryWrapper<User> queryWrapper = new QueryWrapper<>();
       queryWrapper.like("name","a")
               .between("age",20,30)
               .isNotNull("email");
       final List<User> users = mapper.selectList(queryWrapper);
       users.forEach(System.out::println);
//==>  Preparing: SELECT id,name,is_deleted,age,email FROM user WHERE is_deleted=0 AND (name LIKE ? AND age BETWEEN ? AND ? AND email IS NOT NULL)
//==>  Parameters: %a%(String), 20(Integer), 30(Integer)
   }

    @Test
    public void test2(){
       //查询用户信息，按照age降序排序，其次按照id升序排序
       QueryWrapper<User> queryWrapper = new QueryWrapper<>();
       queryWrapper.orderByDesc("age")
               .orderByAsc("id");
       final List<User> users = mapper.selectList(queryWrapper);
       users.forEach(System.out::println);
//==>  Preparing: SELECT id,name,is_deleted,age,email FROM user WHERE is_deleted=0 ORDER BY age DESC,id ASC
   }

    @Test
    public void test3(){
       //删除email为空的用户信息
       QueryWrapper<User> queryWrapper = new QueryWrapper<>();
       queryWrapper.isNull("email")
               .last("or length(trim(email))=0");
        final int result = mapper.delete(queryWrapper);
        System.out.println("result"+result);
//==> Preparing: UPDATE user SET is_deleted=1 WHERE is_deleted=0 AND (email IS NULL) or length(trim(email))=0
    }

    @Test
    public void test4(){
       //修改用户名包含a，age>=20或者email为空的用户信息
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("age",20)
                .like("name","a")
                .or()
                .isNull("email");
        final int result = mapper.update(new User("小明", "baidu@123.com"), queryWrapper);
        System.out.println("result"+result);
//==> UPDATE user SET name=?, email=? WHERE is_deleted=0 AND (age > ? AND name LIKE ? OR email IS NULL)
//==> Parameters: 小明(String), baidu@123.com(String), 20(Integer), %a%(String)
    }

    @Test
    public void test5(){
        //test4:将(年龄大于20并且用户名中包含有a)或邮箱为null的用户信息修改
        //test5:将用户名中包含有a并且(年龄大于20或邮箱为null)的用户信息修改
        //lambda表达式的条件优先执行
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name","a")
                .and(queryWrapper2->queryWrapper2.gt("age",20).or().isNull("email"));
        final int result = mapper.update(new User("小红", "guge@123.com"), queryWrapper);
        System.out.println("result"+result);
//==> UPDATE user SET name=?, email=? WHERE is_deleted=0 AND (name LIKE ? AND (age > ? OR email IS NULL))
//==> Parameters: 小红(String), guge@123.com(String), %a%(String), 20(Integer)
    }

     @Test
    public void test6(){
        //查询用户的姓名、年龄、邮箱
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("name","age","email");
         final List<Map<String, Object>> maps = mapper.selectMaps(queryWrapper);
         maps.forEach(System.out::println);
    }

    @Test
    public void test7(){
        //查询id<=100的用户信息(子查询)
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.inSql("age","SELECT id FROM user WHERE id <= 100");
        final List<User> list = mapper.selectList(queryWrapper);
        list.forEach(System.out::println);
    }

    @Test
    public void test8(){
        //将用户名包含a并且（年龄大于20或邮箱为空）的用户信息修改
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.like("name","a")
                .and(i -> i.gt("age",20).or().isNull("email"));
        updateWrapper.set("name","小李").set("email","alibaba@123.com");
        final int result = mapper.update(null, updateWrapper);
        System.out.println("result = " + result);
//Preparing: UPDATE user SET name=?,email=? WHERE is_deleted=0 AND (name LIKE ? AND (age > ? OR email IS NULL))
    }

    @Test
    public void test9(){
        //模拟实际开发中的前端传来条件的组织情况
        String username = "a";
        Integer aggBegin = null;
        Integer aggEnd = 30;
//==>  Preparing: SELECT id,name,is_deleted,age,email FROM user WHERE is_deleted=0 AND (name LIKE ? AND age <= ?)
//==> Parameters: %a%(String), 30(Integer)

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(username)){
            queryWrapper.like("name",username);
        }
        if(aggBegin != null){
            queryWrapper.ge("age",aggBegin);
        }
        if(aggEnd != null){
            queryWrapper.le("age",aggEnd);
        }
        final List<User> users = mapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test10(){
        //模拟实际开发中的前端传来条件的组织情况,用condition
        String username = "a";
        Integer aggBegin = 20;
        Integer aggEnd = 30;
//==>  Preparing: SELECT id,name,is_deleted,age,email FROM user WHERE is_deleted=0 AND (name LIKE ? AND age >= ? AND age <= ?)
//==> Parameters: %a%(String), 20(Integer), 30(Integer)

        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
            queryWrapper.like(StringUtils.isNotBlank(username),"name",username)
                    .ge(aggBegin != null,"age",aggBegin)
                    .le(aggEnd != null,"age",aggEnd);
        final List<User> users = mapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test11(){
        //模拟实际开发中的前端传来条件的组织情况,用LambdaQueryWrapper
        String username = "a";
        Integer aggBegin = 20;
        Integer aggEnd = 30;

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(username),User::getName,username)
                    .ge(aggBegin != null,User::getAge,aggBegin)
                    .le(aggEnd != null,User::getAge,aggEnd);
        final List<User> users = mapper.selectList(queryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void test12(){
        //将用户名包含a并且（年龄大于20或邮箱为空）的用户信息修改，用LambdaUpdateWrapper
        LambdaUpdateWrapper<User> updateWrapper = new LambdaUpdateWrapper<>();
        updateWrapper.like(User::getName,"a")
                .and(i -> i.gt(User::getAge,20).or().isNull(User::getEmail));
        updateWrapper.set(User::getName,"小李").set(User::getEmail,"alibaba@123.com");
        final int result = mapper.update(null, updateWrapper);
        System.out.println("result = " + result);
    }

}
