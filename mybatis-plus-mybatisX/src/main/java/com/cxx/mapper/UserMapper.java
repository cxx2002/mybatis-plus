package com.cxx.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cxx.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
* @author 陈喜喜
* @description 针对表【user】的数据库操作Mapper
* @createDate 2022-08-17 09:56:59
* @Entity com.cxx.pojo.User
*/
public interface UserMapper extends BaseMapper<User> {

    int insertSelective(User user);

    List<User> selectAllBySexOrderByAgeDesc(@Param("sex") Boolean sex);

    List<User> selectAll();

    int deleteById(@Param("id") Long id);

    List<User> selectNameAndAgeByAgeBetweenOrderByAgeDesc(@Param("beginAge") Integer beginAge, @Param("endAge") Integer endAge);

}




