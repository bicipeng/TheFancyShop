package com.fancyshop.ecommerce.model;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.experimental.PackagePrivate;

import java.util.Set;

public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private Integer quantity;    @ManyToMany
    @JoinTable(name="Oder", joinColumns = @JoinColumn(name="product_id"),
    inverseJoinColumns =@JoinColumn (name="order_id"))
    private Set<Order> orders;

    public Long getId(){return id;};
    public void setId(Long id){this.id = id;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public double getPrice(){return price;}
    public void setPrice(Double price){this.price = price;}

    public Integer getQuantity(){return quantity;}
    public void setQuantity(Integer quantity){this.quantity = quantity;}

    





}
