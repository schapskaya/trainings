package com.task.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.TimeZone;

/**
 * Created with IntelliJ IDEA.
 * User: Svetlana Chapskaya
 * Date: 14.01.2017
 * Time: 18:05
 * To change this template use File | Settings | File Templates.
 */
public class Product {

    private String name;

    private Double price;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss") //, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")//, timezone = "UTC"
    private Date dateChanged;

    public Product(String name, Double price, Date dateChanged) {
        this.setName(name);
        this.setPrice(price);
        this.setDateChanged(dateChanged);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Date getDateChanged() {
        return dateChanged;
    }

    public void setDateChanged(Date dateChanged) {
        this.dateChanged = dateChanged;
    }
}
