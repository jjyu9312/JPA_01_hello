package com.springwook.jpa_01_hello.jpa01;

import javax.persistence.Entity;

@Entity
public class Book extends Item{

    private String author;
    private String isbn;
}
