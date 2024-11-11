package com.example.springbootexperiment.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootexperiment.entity.Book;
import com.example.springbootexperiment.entity.BookUserVO;
import com.example.springbootexperiment.mapper.BookMapper;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl extends ServiceImpl<BookMapper, Book> implements BookService {
    private final BookMapper bookMapper;

    @PostConstruct
    public void created() {
        System.out.println("BookServiceImpl created!");
    }

    @PreDestroy
    public void beforeDestroy() {
        System.out.println("BookServiceImpl before destroy!");
    }

    public BookServiceImpl(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public boolean saveBook(Book book) {
        return save(book);
    }

    @Override
    public boolean removeBookById(Long id) {
        return removeById(id);
    }

    @Override
    public boolean updateBookById(Book book) {
        return updateById(book);
    }

    @Override
    public Book getBookById(Long id) {
        return getById(id);
    }

    @Override
    public List<Book> listBooks() {
        return list();
    }

    @Override
    public Book getUserWithNestedBookQuery(Long id) {
        return bookMapper.getUserWithNestedBookQuery(id);
    }

    @Override
    public Page<Book> pageByUsername(int pageNum, int pageSize, String userName) {
        Page<Book> page = new Page<>(pageNum, pageSize);
        return bookMapper.selectPageByUsername(page, userName);
    }

    @Override
    public Page<BookUserVO> pageByUserName(int pageNum, int pageSize, String username) {
        Page<BookUserVO> page = new Page<>(pageNum, pageSize); // 使用VO进行分页
        return bookMapper.selectPageByUserName(page, username);
    }
}
