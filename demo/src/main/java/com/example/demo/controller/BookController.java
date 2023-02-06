package com.example.demo.controller;


import com.example.demo.entity.Book;
import com.example.demo.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
//@RequiredArgsConstructor
public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping("/savebook")
    public Book saveBook(@RequestBody Book book){
      //  System.out.println("hello");
  return this.bookService.saveBook(book);
    }

    @GetMapping("/getAll")
    public List<Book> getAllBook(){
        return this.bookService.getBook();
    }

    @GetMapping("/getid/{id}")
    public Book getBook(@PathVariable long id ){
        return this.bookService.getBookById(id);
    }


}
