package com.example.demo.service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;
    public Book saveBook(Book book){
        System.out.println("serviuce");  System.out.println(book.getIsbn());
        System.out.println(book.getProperties()+"asdf");

        System.out.println(book.getIsbn());
        System.out.println(book.getProperties());
        return this.bookRepository.save(book);
    }

    public List<Book> getBook() {
        return this.bookRepository.findAll();
    }


    public Book getBookById(long id) {
        return this.bookRepository.findById(id).get();
    }
}
