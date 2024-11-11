package com.example.springbootexperiment.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootexperiment.entity.User;
import com.example.springbootexperiment.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public boolean saveUser(User user) {
        return save(user);
    }

    @Override
    public boolean removeUserById(Long id) {
        return removeById(id);
    }

    @Override
    public boolean updateUserById(User user) {
        return updateById(user);
    }

    @Override
    public User getUserById(Long id) {
        return getById(id);
    }

    @Override
    public List<User> listUsers() {
        return list();
    }

    @Override
    public User getUserAndBooksByUserName(String userName) {
        return userMapper.selectUserAndBooksByUserName(userName);
    }

}
