package com.example.springbootexperiment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("books")
public class Book {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private String title;
    @TableField(value = "user_id")
    private Long userId;
    @TableField(exist = false)
    private User user;
}
