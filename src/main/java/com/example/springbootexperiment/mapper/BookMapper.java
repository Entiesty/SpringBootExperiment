package com.example.springbootexperiment.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootexperiment.entity.Book;
import com.example.springbootexperiment.entity.BookUserVO;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface BookMapper extends BaseMapper<Book> {
    @Select("SELECT * FROM books WHERE user_id = #{userId} LIMIT 0,2")
    List<Book> selectByUId(@Param("userId") Long userId);

    @Select("SELECT * FROM books WHERE id = #{id}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "user", column = "user_id",
            one = @One(select = "com.example.springbootexperiment.mapper.UserMapper.getUserById"))
    })
    Book getUserWithNestedBookQuery(@Param("id") Long id);

    @Select("SELECT b.*, u.* FROM books b LEFT JOIN users u ON\n" +
            " u.id = b.user_id WHERE u.name LIKE CONCAT('%',#{username},'%')")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "title", column = "title"),
            @Result(property = "userId", column = "user_id"),
            @Result(property = "user", column = "user_id",
                    one = @One(select = "com.example.springbootexperiment.mapper.UserMapper.getUserById"))
    })
    Page<Book> selectPageByUsername(Page<?> page, @Param("username") String username);

    @Select("SELECT b.*, " +
            "u.id AS userId, u.name AS userName, u.balance AS userBalance " +
            "FROM books b " +
            "LEFT JOIN users u ON b.user_id = u.id " +
            "WHERE u.name LIKE CONCAT('%', #{username}, '%')")
    Page<BookUserVO> selectPageByUserName(Page<BookUserVO> page, @Param("username") String username);
}
