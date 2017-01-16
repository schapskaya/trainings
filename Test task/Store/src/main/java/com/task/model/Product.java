package com.task.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

/**
 * Created with IntelliJ IDEA.
 * User: Svetlana Chapskaya
 * Date: 14.01.2017
 * Time: 18:05
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Product {

    @Column(nullable = false)
    @NotNull(message = "Product name should not be null")
    private String name;

    @Column(nullable = false)
    @NotNull(message = "Product price should not be null")
    private Double price;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss") //, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSZ")//, timezone = "UTC"
    @Column(nullable = false)
    @NotNull(message = "Price changed date should not be null")
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

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || !this.getClass().equals(other.getClass())) {
            return false;
        }
        Product that = (Product) other;
        return Objects.equals(this.getName(), that.getName())
                && Objects.equals(this.getPrice(), that.getPrice())
                && Objects.equals(this.getDateChanged(), that.getDateChanged());
    }

    @Override
    public int hashCode() {
        int result = Objects.hashCode(name);
        result = 31 * result + Objects.hashCode(price);
        result = 31 * result + Objects.hashCode(dateChanged);
        return result;
    }
}
