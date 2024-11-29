package com.springboot.bookstore.controller;

import com.springboot.bookstore.dto.BookDto;
import com.springboot.bookstore.entity.Book;
import com.springboot.bookstore.service.BookService;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    //for getting all book from db
    @RequestMapping("/getBooks")
    public List<Book> getBooks(){
       return bookService.getBooks();
    }

    //for post the book details in db
    @PostMapping("/saveBook")
    public Book createBook(@RequestBody Book book){
        return bookService.createBook(book);
    }

    //for getting only one book details by id
    @GetMapping("/getBook/{id}")
    public Optional<Book> getBook(@PathVariable("id") Integer id){
        return bookService.getBook(id);
    }

    //updating the book details
    @PutMapping("/updateBook")
    public Book updateBook(@RequestBody Book book){
        return bookService.updateBook(book);
    }

    //delete book by id
    @DeleteMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable Integer id){
        return bookService.deleteBook(id);
    }

    //signle query param
    @GetMapping("/getAllBook")
    public List<Book> getAllBook(@RequestParam(value = "YearOfPublication", required = false) Integer yop){
        return bookService.getAllBook(yop);

    }

    //In single query param passing multiple values
    @GetMapping("/getAllBooks")
    public List<Book> getAllBooks(@RequestParam(value = "YearOfPublication", required = false)Set<Integer> yop){
        return bookService.getAllBooks(yop);
    }

    //multiple query param
    @GetMapping("/getBook")
    public List<Book> getBook(@RequestParam(value = "YearOfPublication", required = false) Integer yop,
                              @RequestParam(value = "name", required = false) String name){
        return bookService.getBookName(yop,name);

    }

    //raw query
    @GetMapping("/raw/books")
    public List<Book> getBooksByRaw(@RequestParam(value = "description") String desc){
        return bookService.getBookByRaw(desc);
    }

    //mapping table
    @GetMapping("/author/getBooks/{id}")
    public BookDto getBookAuthor(@PathVariable("id")Integer id, @RequestParam(value = "authorType",required = false) Boolean authorType){
        return bookService.getBookAuthor(id,authorType);
    }
}
