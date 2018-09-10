package com.unil.search.book.repository;

import com.unil.search.book.repository.entity.BookEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author liuwh33
 * @date 2018/9/10 15:20
 * @desc
 */
@Repository
public interface BookRepository extends ElasticsearchRepository<BookEntity, String> {

    Page<BookEntity> findAll();
}
