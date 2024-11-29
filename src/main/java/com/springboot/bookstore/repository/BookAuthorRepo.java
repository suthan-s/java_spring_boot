package com.springboot.bookstore.repository;

import com.springboot.bookstore.entity.Author;
import com.springboot.bookstore.entity.BookAuthor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookAuthorRepo extends CrudRepository<BookAuthor,Integer> {

    List<BookAuthor> findAllByBookId(Integer id);
}
