package com.example.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Generar id automaticamente
    private Long id;
    private String title;
    private Double price;
    private Integer numPages;

    public Book() {

    }
    // Constructor
    public Book(Long id, String title, Double price, Integer numPages) {

        this.id = id;
        this.title = title;
        this.price = price;
        this.numPages = numPages;
    }

// Método Getter


    public Long getId() {  return id; }

    public java.lang.String getTitle() {  return title; }


    public Double getPrice() { return price; }

    public Integer getNumPages() { return numPages; }

    // Método Setter

    public void setId(Long id) { this.id = id; }

    public void setTitle(String title) { this.title = title; }

    public void setPrice(Double price) { this.price = price; }

    public void setNumPages(Integer numPages) { this.numPages = numPages; }


    //  Método toString

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", numPages=" + numPages +
                '}';
    }


}

