package com.example.springbootexperiment.service;

import com.example.springbootexperiment.mapper.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferServiceImpl implements TransferService{
    private final UserMapper userMapper;

    public TransferServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Transactional(rollbackFor = Exception.class)
    public void transfer(Long fromUserId, Long toUserId, Double amount) throws Exception {
        userMapper.increaseBalance(amount, toUserId);

        Double balance = userMapper.getBalance(fromUserId);
        if(balance.compareTo(amount) < 0) {
            throw new Exception("余额不足，无法完成转账");
        }
        else {
            userMapper.decreaseBalance(amount, fromUserId);
        }
    }
}
