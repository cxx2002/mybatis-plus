package com.cxx.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxx.mapper.UserMapper;
import com.cxx.pojo.User;
import com.cxx.service.UserService;
import org.springframework.stereotype.Service;

/**
 * @author 陈喜喜
 * @date 2022-08-16 21:11
 */
@DS("master") //指定操作的数据源，master为user表
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
