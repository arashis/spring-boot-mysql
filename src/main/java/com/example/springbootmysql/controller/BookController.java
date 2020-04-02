package com.example.springbootmysql.controller;

import com.example.springbootmysql.model.Book;
import com.example.springbootmysql.model.BookIdAndTitle;
import com.example.springbootmysql.model.User;
import com.example.springbootmysql.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @Autowired
    User user;

    @RequestMapping(method = RequestMethod.GET, path = "/")
    public ResponseEntity<List<Book>> getBooks() {
        return new ResponseEntity<>(bookService.getBooks(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{bookId}")
    public ResponseEntity<BookIdAndTitle> getBook(@PathVariable(value = "bookId") int bookId) {
        return new ResponseEntity<>(bookService.getBook(bookId), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, path = "/")
    public ResponseEntity<Integer> addBook(@RequestHeader("User-Name") String userName, @RequestBody Book book) {
        user.setUserName(userName);
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{bookId}")
    public ResponseEntity<Integer> putBook(@RequestHeader("User-Name") String userName, @PathVariable(value = "bookId") int bookId, @RequestBody Book book) {
        user.setUserName(userName);
        book.setBookId(bookId);
        return new ResponseEntity<>(bookService.addBook(book), HttpStatus.NO_CONTENT);
    }
}
