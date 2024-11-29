package com.springboot.bookstore.repository;

import com.springboot.bookstore.entity.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface BookRepo extends CrudRepository<Book,Integer> { //Book - entity, Integer- primary key data type
    List<Book> findAllByYear(Integer yop);

    List<Book> findAllByYearIn(Set<Integer> yop);

    List<Book> findAllByYearAndName(Integer yop, String name);

    String rawQuery = "select * from book where description =:desc";
    @Query(nativeQuery = true, value = rawQuery)
    List<Book> findAllByDesc(@Param("desc") String desc);
}
