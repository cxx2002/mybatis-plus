package com.cxx2.service.impl;

import com.cxx2.entity.User;
import com.cxx2.mapper.UserMapper;
import com.cxx2.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author cxx
 * @since 2022-08-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
