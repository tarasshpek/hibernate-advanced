package com.example.demo.product;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "PRODUCT", indexes = @Index(columnList = "price"))
public class Product {

    @EmbeddedId
    private ProductId id;

    private BigDecimal price;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable
    private List<Category> categories;

    public Product() {
    }

    public Product(String name, String brand, BigDecimal price) {
        this.id = new ProductId();
        this.id.setName(name);
        this.id.setBrand(brand);
        this.price = price;
    }

    public ProductId getId() {
        return id;
    }

    public void setId(ProductId id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", price=" + price +
                ", categories=" + categories +
                '}';
    }
}
