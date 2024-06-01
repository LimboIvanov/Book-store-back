package com.onlinebookstore.bookstoreback2.service;

import com.onlinebookstore.bookstoreback2.dto.BookDto;
import com.onlinebookstore.bookstoreback2.dto.search.BookSearchDto;
import com.onlinebookstore.bookstoreback2.mapper.BookMapper;
import com.onlinebookstore.bookstoreback2.model.Book;
import com.onlinebookstore.bookstoreback2.repository.BookRepository;
import jdk.jshell.spi.ExecutionControl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional; //?
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;


@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class BookService {

    private final BookRepository repository;
    private final BookMapper mapper;

    public BookDto create(BookDto bookDto) {
        Book book = mapper.toEntity(bookDto);
        return mapper.toDto(repository.save(book));
    }

    public BookDto findBookById(Long id) throws Exception {
        Book book = repository.findById(id).orElseThrow(() -> new Exception("Book#" + id + " not found"));
        return mapper.toDto(book);
    }

    public List<BookDto> findAllBooks() {
        List<Book> books = repository.findAll();
        return mapper.toDtos(books);
    }

    public List<BookDto> findAllBooks(BookSearchDto searchDto) {
        Specification<Book> spec = searchDto.getSpecification();
        Pageable pageable = searchDto.getPageable();
        Page<Book> booksPage = repository.findAll(spec, pageable);
        return mapper.toDtos(booksPage.getContent());
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public BookDto update(BookDto bookDto) throws Exception {
        Book book = repository.findById(bookDto.getId()).orElseThrow(()
                -> new Exception("Book#" +bookDto.getId() + " not found"));
        mapper.update(book, bookDto);
        repository.save(book);
        return mapper.toDto(book);
    }

    public Page<BookDto>  getAll(BookSearchDto bookSearchDto) {

        Page<Book> bookPage = repository.findAll(bookSearchDto.getSpecification(), bookSearchDto.getPageable());
        List<BookDto> bookDtos = mapper.toDtos(bookPage.getContent());
        return new PageImpl<>(bookDtos, bookSearchDto.getPageable(), bookPage.getTotalElements());
    }


}
