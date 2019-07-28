package com.hansa.sample;

import java.io.Serializable;

public class Book implements Serializable {
    private String isbn;
    private String desc;
    private String price;

    // Constructors
    public Book() {}
    public Book(String isbn, String desc, String price) {
        this.isbn = isbn;
        this.desc = desc;
        this.price = price;
    }

    // Getters and Setters
    public String getIsbn() {return isbn;}

    public void setIsbn(String isbn) {this.isbn = isbn;}

    public String getDesc() {return desc;}

    public void setDesc(String desc) {this.desc = desc;}

    public String getPrice() {return price;}

    public void setPrice(String price) {this.price = price;}
}


