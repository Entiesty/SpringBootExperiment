package com.example.springbootexperiment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.springbootexperiment.entity.Book;
import com.example.springbootexperiment.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper extends BaseMapper<User> {
    @Select("SELECT * FROM users WHERE name = #{userName}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "name", column = "name"),
            @Result(property = "balance", column = "balance"),
            @Result(property = "books", javaType = List.class, column = "id",
                    many = @Many(select = "com.example.springbootexperiment.mapper.BookMapper.selectByUId"))
    })
    User selectUserAndBooksByUserName(@Param("userName") String userName);

    @Select("SELECT * FROM users WHERE id = #{userId}")
    User getUserById(@Param("userId") Long userId);

    @Update("UPDATE users SET balance = balance + #{amount}  WHERE id = #{id}")
    void increaseBalance(@Param("amount") Double amount, @Param("id") Long id);

    @Update("UPDATE users SET balance = balance - #{amount} WHERE id = #{id}")
    void decreaseBalance(@Param("amount") Double amount, @Param("id") Long id);

    @Select("SELECT balance FROM users WHERE id = #{id}")
    Double getBalance(@Param("id") Long id);

}
