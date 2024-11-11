package com.example.springbootexperiment.service;

public interface TransferService {
    void transfer(Long fromUserId, Long toUserId, Double amount) throws Exception;
}
