package com.unil.search.book.repository.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.Date;

/**
 * @author liuwh33
 * @date 2018/9/10 15:20
 * @desc
 */
@Data
@Document(indexName = "idx_unil", type = "book")
public class BookEntity {

    @Id
    private String id;
    private String title;
    private String author;
    private String brief;
    private String content;
}
