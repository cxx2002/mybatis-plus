package com.cxx.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cxx.pojo.User;
import com.cxx.service.UserService;
import com.cxx.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author 陈喜喜
* @description 针对表【user】的数据库操作Service实现
* @createDate 2022-08-17 09:56:59
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




