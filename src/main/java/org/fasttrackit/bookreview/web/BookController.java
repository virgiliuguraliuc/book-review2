package org.fasttrackit.bookreview.web;

import org.fasttrackit.bookreview.domain.Book;
import org.fasttrackit.bookreview.service.BookService;
import org.fasttrackit.bookreview.transfer.book.book.GetBookRequest;
import org.fasttrackit.bookreview.transfer.book.book.SaveBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;
    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<Book> createBook(@RequestBody @Valid SaveBookRequest request) {
        Book book = bookService.createBook(request);
        return new ResponseEntity<>(book, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Book> getBook(@PathVariable("id") long id) {
        Book book = bookService.getBook(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    @GetMapping
    public ResponseEntity<Page<Book>> getBooks(GetBookRequest request, Pageable pageable){
        Page<Book> books = bookService.getBooks(request, pageable);
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable("id") long id, @RequestBody SaveBookRequest request){
        Book book = bookService.updateBook(id, request);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteBook(@PathVariable("id") long id) {
        bookService.deleteBook(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }



}
