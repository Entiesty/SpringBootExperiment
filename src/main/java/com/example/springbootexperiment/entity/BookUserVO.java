package com.example.springbootexperiment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookUserVO {
    private Long bookId;
    private String title;
    private String author;
    private Long userId;
    private String userName;
    private Double userBalance;
}

