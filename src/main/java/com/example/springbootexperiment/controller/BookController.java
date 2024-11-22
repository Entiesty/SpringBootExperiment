package com.example.springbootexperiment.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.springbootexperiment.entity.Book;
import com.example.springbootexperiment.entity.BookUserVO;
import com.example.springbootexperiment.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @Operation(summary = "保存书籍", description = "根据传入的书籍对象保存书籍信息")
    @RequestBody(description = "书籍对象", required = true)
    @PostMapping
    public boolean saveBook(@RequestBody Book book) {
        return bookService.saveBook(book);
    }

    @Operation(summary = "删除书籍", description = "根据书籍ID删除书籍")
    @Parameter(name = "id", description = "书籍ID", required = true)
    @DeleteMapping("/{id}")
    public boolean removeBookById(@PathVariable Long id) {
        return bookService.removeBookById(id);
    }

    @Operation(summary = "更新书籍", description = "根据书籍ID更新书籍信息")
    @RequestBody(description = "更新的书籍信息", required = true)
    @PutMapping
    public boolean updateBookById(@RequestBody Book book) {
        return bookService.updateBookById(book);
    }

    @Operation(summary = "查询书籍", description = "根据书籍ID查询书籍信息")
    @Parameter(name = "id", description = "书籍ID", required = true)
    @GetMapping("/{id}")
    public Book getBookById(@PathVariable Long id) {
        return bookService.getBookById(id);
    }

    @Operation(summary = "查询用户的书籍", description = "根据用户ID查询该用户的书籍信息")
    @Parameter(name = "id", description = "用户ID", required = true)
    @GetMapping("/users/{id}")
    public Book getUserWithNestedBookQuery(@PathVariable Long id) {
        return bookService.getUserWithNestedBookQuery(id);
    }

    @Operation(summary = "查询所有书籍", description = "查询所有书籍列表")
    @GetMapping
    public List<Book> listBooks() {
        return bookService.listBooks();
    }

    @Operation(summary = "分页查询书籍", description = "根据用户名进行分页查询书籍信息")
    @Parameter(name = "pageNum", description = "页码", required = true)
    @Parameter(name = "pageSize", description = "每页大小", required = true)
    @Parameter(name = "userName", description = "用户名", required = true)
    @GetMapping("/pageByUsername")
    public List<Book> pageByUsername(@RequestParam("pageNum") int pageNum,
                                     @RequestParam("pageSize") int pageSize,
                                     @RequestParam("userName") String userName) {
        return bookService.pageByUsername(pageNum, pageSize, userName).getRecords();
    }

    @Operation(summary = "分页查询书籍（VO）", description = "根据用户名分页查询书籍信息并返回VO对象")
    @Parameter(name = "pageNum", description = "页码", required = true)
    @Parameter(name = "pageSize", description = "每页大小", required = true)
    @Parameter(name = "username", description = "用户名", required = true)
    @GetMapping("/pageByUserName")
    public Page<BookUserVO> pageByUserName(@RequestParam("pageNum") int pageNum,
                                           @RequestParam("pageSize") int pageSize,
                                           @RequestParam("username") String username) {
        return bookService.pageByUserName(pageNum, pageSize, username);
    }
}

