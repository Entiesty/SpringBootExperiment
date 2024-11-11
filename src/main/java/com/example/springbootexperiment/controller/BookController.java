package com.example.springbootexperiment.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootexperiment.entity.Book;
import com.example.springbootexperiment.entity.BookUserVO;
import com.example.springbootexperiment.service.BookService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public boolean saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @DeleteMapping("/{id}")
    public boolean removeBookById(@PathVariable Long id) {
        return bookService.removeBookById(id);
    }

    @PutMapping
    public boolean updateBookById(@RequestBody Book book) {
        return bookService.updateBookById(book);
    }

    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @GetMapping("/users/{id}")
    public Book getUserWithNestedBookQuery(@PathVariable Long id) {
        return bookService.getUserWithNestedBookQuery(id);
    }

    @GetMapping
    public List<Book> listBooks() {
        return bookService.listBooks();
    }

    @GetMapping("/pageByUsername")
    public List<Book> pageByUsername(@RequestParam("pageNum") int pageNum,
                                      @RequestParam("pageSize") int pageSize,
                                      @RequestParam("userName") String userName) {
        return bookService.pageByUsername(pageNum, pageSize, userName).getRecords();
    }

    @GetMapping("/pageByUserName")
    public Page<BookUserVO> pageByUserName(@RequestParam("pageNum") int pageNum,
                                           @RequestParam("pageSize") int pageSize,
                                           @RequestParam("username") String username) {
        return bookService.pageByUserName(pageNum, pageSize, username);
    }
}
