package com.example.giuakikiemtra.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String detail;
    private int price;
    private String day;

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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public Product() {
    }

    public Product(String name, String detail, int price, String day) {
        this.name = name;
        this.detail = detail;
        this.price = price;
        this.day = day;
    }

    public Product(int id, String name, String detail, int price, String day) {
        this.id = id;
        this.name = name;
        this.detail = detail;
        this.price = price;
        this.day = day;
    }
}
