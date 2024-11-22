package com.example.springbootexperiment.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("books")
public class Book {

    @Schema(description = "书籍ID", example = "1")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @Schema(description = "书籍标题", example = "Spring Framework 5")
    private String title;

    @Schema(description = "用户ID", example = "101")
    @TableField(value = "user_id")
    private Long userId;

    @Schema(description = "与用户关联的 User 对象", accessMode = Schema.AccessMode.READ_ONLY)
    @TableField(exist = false)
    private User user;
}

