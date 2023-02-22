package com.eCommerce.JaiKissan.Entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
public class SubCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String productName;
    @ManyToOne
    @JsonIgnore
    private Category Categories;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Product product;


    public SubCategory() {
    }

    public SubCategory(int id, String productName, Category categories, Product product) {
        this.id = id;
        this.productName = productName;
        Categories = categories;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Category getCategories() {
        return Categories;
    }

    public void setCategories(Category categories) {
        Categories = categories;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", Categories=" + Categories +
                ", product=" + product +
                '}';
    }
}