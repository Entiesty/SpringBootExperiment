package com.example.springbootexperiment.controller;

import com.example.springbootexperiment.service.TransferService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/transfer")
public class TransferController {
    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/execute")
    public ResponseEntity<String> transfer(@RequestParam("fromUserId") Long fromUserId,
                                           @RequestParam("toUserId") Long toUserId,
                                           @RequestParam("amount") Double amount) {
        try {
            transferService.transfer(fromUserId, toUserId, amount);
            return ResponseEntity.ok("转账成功");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
