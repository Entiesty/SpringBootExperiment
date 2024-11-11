package com.example.springbootexperiment.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootexperiment.entity.Book;
import com.example.springbootexperiment.entity.BookUserVO;

import java.util.List;

public interface BookService {

    boolean saveBook(Book book);
    boolean removeBookById(Long id);
    boolean updateBookById(Book book);
    Book getBookById(Long id);
    List<Book> listBooks();
    Book getUserWithNestedBookQuery(Long id);

    Page<Book> pageByUsername(int pageNum, int pageSize, String userName);

    Page<BookUserVO> pageByUserName(int pageNum, int pageSize, String username);
}
