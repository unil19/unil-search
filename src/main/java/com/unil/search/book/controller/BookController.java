package com.unil.search.book.controller;

import com.unil.search.book.repository.BookRepository;
import com.unil.search.book.repository.entity.BookEntity;
import com.unil.search.common.dto.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @author liuwh33
 * @date 2018/9/10 15:21
 * @desc
 */
@RestController
@RequestMapping(value = "/books", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @GetMapping()
    private SearchResponse getBooks(){
        SearchResponse searchResponse = new SearchResponse();
        List<BookEntity> books = bookRepository.findAll().getContent();
        searchResponse.setData(books);
        searchResponse.setMsg("查询书籍列表成功");
        return searchResponse;
    }

    @GetMapping("/{bookId}")
    private SearchResponse getBooksById(@PathVariable String bookId){
        SearchResponse searchResponse = new SearchResponse();
        Optional<BookEntity> booksOptional = bookRepository.findById(bookId);
        if(booksOptional.isPresent()){
            searchResponse.setMsg("查询书籍信息成功");
            searchResponse.setData(booksOptional.get());
        } else {
            searchResponse.setCode("1");
            searchResponse.setMsg("查询书籍不存在");
        }
        return searchResponse;
    }

    @PostMapping
    private SearchResponse addBooks(@RequestBody BookEntity bookEntity){
        bookEntity.setId(UUID.randomUUID().toString());
        bookRepository.save(bookEntity);
        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setMsg("添加书籍成功");
        return searchResponse;
    }

    @PutMapping("/{bookId}")
    private SearchResponse updateBooks(@PathVariable String bookId, @RequestBody BookEntity bookEntity){
        bookEntity.setId(bookId);
        bookRepository.save(bookEntity);
        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setMsg("更新书籍成功");
        return searchResponse;
    }

    @DeleteMapping("/{bookId}")
    private SearchResponse removeBooks(@PathVariable String bookId){
        BookEntity bookEntity = new BookEntity();
        bookEntity.setId(bookId);
        bookRepository.delete(bookEntity);
        SearchResponse searchResponse = new SearchResponse();
        searchResponse.setMsg("删除书籍成功");
        return searchResponse;
    }
}
