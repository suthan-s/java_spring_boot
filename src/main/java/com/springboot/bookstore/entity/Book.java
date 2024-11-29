package com.springboot.bookstore.entity;

import jakarta.persistence.*;

@Entity
public class Book {
    @Id // for primary key using @Id annotation
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //for auto increment in id
    private int id;
    private String name;
    //desc is the sql one component name so if we use we are getting error so we changed the name in db.
    @Column(name = "description")  //so that here we need to change the name so we used this annotation
    private String desc;
    private int year;
    private String bookType;

    public Book(){  //we need default constructor for getting details from db else we are getting error

    }

    public Book(int id, String name, String desc, int year, String bookType) {
        this.id = id;
        this.name = name;
        this.desc = desc;
        this.year = year;
        this.bookType = bookType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getBookType() {
        return bookType;
    }

    public void setBookType(String bookType) {
        this.bookType = bookType;
    }
}
