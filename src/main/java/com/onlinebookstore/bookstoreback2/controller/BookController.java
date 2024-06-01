package com.onlinebookstore.bookstoreback2.controller;

import com.onlinebookstore.bookstoreback2.dto.BookDto;
import com.onlinebookstore.bookstoreback2.dto.search.BookSearchDto;
import com.onlinebookstore.bookstoreback2.service.BookService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin("*")
@RestController
@AllArgsConstructor
@RequestMapping("/api")
@Slf4j
public class BookController {

    private BookService bookService;

    @PostMapping(value = "/books")
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto) {
        return ResponseEntity.ok().body(bookService.create(bookDto));
    }
    @GetMapping(value = "/books/{id}")
    public ResponseEntity<BookDto> getBookById(@PathVariable(value = "id") final Long id) throws Exception {
        BookDto bookFound = bookService.findBookById(id);
        return ResponseEntity.ok().body(bookFound);
    }

    @GetMapping(value = "/books")
    public ResponseEntity<List<BookDto>> getAllBooks() {
        return ResponseEntity.ok().body(bookService.findAllBooks());
    }

    @DeleteMapping("/books/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/books")
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto) throws Exception {
        return ResponseEntity.ok().body(bookService.update(bookDto));
    }

    @GetMapping(value = "/books/search", produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<List<BookDto>> getAll(@RequestBody BookSearchDto bookSearchDto) {
        log.debug("REST request to search Book");
        return ResponseEntity.ok().body(bookService.getAll(bookSearchDto).toList());
    }

}
