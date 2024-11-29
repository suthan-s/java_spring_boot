package com.springboot.bookstore.service;

import com.springboot.bookstore.dto.AuthorDto;
import com.springboot.bookstore.dto.BookDto;
import com.springboot.bookstore.entity.Author;
import com.springboot.bookstore.entity.Book;
import com.springboot.bookstore.entity.BookAuthor;
import com.springboot.bookstore.repository.BookAuthorRepo;
import com.springboot.bookstore.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    @Autowired
    private BookAuthorRepo bookAuthorRepo;

    public List<Book> getBooks(){
        List<Book> bookList = new ArrayList<>();
        bookRepo.findAll().forEach(book -> bookList.add(book));
        return bookList;
    }

    public Book createBook(Book book) {
        return bookRepo.save(book);
    }

    public Optional<Book> getBook(Integer id) {
        return bookRepo.findById(id);
    }

    public Book updateBook(Book book) {
        return bookRepo.save(book);
    }

    public String deleteBook(Integer id) {
        bookRepo.deleteById(id);
        return "Deleted successfully";
    }

    public List<Book> getAllBook(Integer yop) {
        List<Book> bookList = new ArrayList<>();
        if (yop==null){
            bookRepo.findAll().forEach(book -> bookList.add(book));
        }
        else {
            return bookRepo.findAllByYear(yop);
        }
        return bookList;
    }

    public List<Book> getAllBooks(Set<Integer> yop) {
        List<Book> bookList = new ArrayList<>();
        if (yop==null){
            bookRepo.findAll().forEach(book -> bookList.add(book));
        }
        else {
             return bookRepo.findAllByYearIn(yop); //findAllByYearIn- in the "In" is using for passing multiple year and get the book details
        }
        return bookList;
    }

    public List<Book> getBookName(Integer yop, String name) {
        List<Book> bookList = new ArrayList<>();
        if (yop ==null&& name==null){
            bookRepo.findAll().forEach(book -> bookList.add(book));
        }
        else {
            return bookRepo.findAllByYearAndName(yop,name);
        }
        return bookList;
    }

    public List<Book> getBookByRaw(String desc) {
        List<Book> bookList= bookRepo.findAllByDesc(desc);
        return bookList;
    }

    public BookDto getBookAuthor(Integer id, Boolean authorType) {
        Optional<Book> book;
        List<BookAuthor> bookAuthors=null;
        book = bookRepo.findById(id);
        if (authorType) {
             bookAuthors= bookAuthorRepo.findAllByBookId(id);
        }
        BookDto bookDto = new BookDto();
        if (book.isPresent()) {
            Book book1 = book.get();
            bookDto.setId(book1.getId());
            bookDto.setName(book1.getName());
            bookDto.setDesc(book1.getDesc());
            bookDto.setYear(book1.getYear());
            bookDto.setBookType(book1.getBookType());
        }
        List<AuthorDto> authorDtoList = new ArrayList<>();
        if (bookAuthors!=null){
            for (BookAuthor bookAuthor:bookAuthors){
                Author author = bookAuthor.getAuthor();

                AuthorDto authorDto = new AuthorDto();
                authorDto.setId(author.getId());
                authorDto.setName(author.getName());
                authorDto.setGender(author.getGender());
                authorDtoList.add(authorDto);
            }
            bookDto.setAthorList(authorDtoList);
        }
        return bookDto;
    }

}
