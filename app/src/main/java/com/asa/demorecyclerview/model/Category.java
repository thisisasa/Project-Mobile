package com.asa.demorecyclerview.model;

import com.asa.demorecyclerview.ProductActivity;

import java.util.List;

public class Category {
    //Data member
    private int id;
    private String name;
    private List<Product> productList;

    //Default Constrature

    public Category() {
    }

    public Category(int id, String name, List<Product> productList) {
        this.id = id;
        this.name = name;
        this.productList = productList;
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

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", productList=" + productList +
                '}';
    }
}
