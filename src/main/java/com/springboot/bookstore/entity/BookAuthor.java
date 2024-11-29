package com.springboot.bookstore.entity;

import jakarta.persistence.*;

@Entity
public class BookAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    //this is use for mapping book entity class to bookauthor class
    @JoinColumn(name = "book_id",referencedColumnName = "id",nullable = false)
    private Book book;
    @ManyToOne
    @JoinColumn(name = "author_id",referencedColumnName = "id",nullable = false)
    private Author author;

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


}
