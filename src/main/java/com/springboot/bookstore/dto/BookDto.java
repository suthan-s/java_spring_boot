package com.springboot.bookstore.dto;

import java.util.List;

public class BookDto {

    private int id;
    private String name;
    private String desc;
    private int year;
    private String bookType;
    private List<AuthorDto> athorList;

    public int getId() {
        return id;
    }

    public List<AuthorDto> getAthorList() {
        return athorList;
    }

    public void setAthorList(List<AuthorDto> athorList) {
        this.athorList = athorList;
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
