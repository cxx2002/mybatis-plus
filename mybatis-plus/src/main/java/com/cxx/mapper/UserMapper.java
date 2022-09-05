package com.cxx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.cxx.pojo.User;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import java.util.Map;

/**
 * @author 陈喜喜
 * @date 2022-08-15 10:17
 * BaseMapper<User>意思就是操作的是user表，实体类与表面相对应
 * 或者加@TableName("user")来指定表
 */

public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据id查询用户信息为map集合
     */
    @MapKey("id")
    Map<String, Object> selectMapById(Long id);
    /**
     * 通过年龄查询用户信息并分页
     * 注意！！！page类型参数必须位于第一个参数位置
     */
    Page<User> selectPageVo(@Param("page")Page<User> page,@Param("age")Integer age);
}
