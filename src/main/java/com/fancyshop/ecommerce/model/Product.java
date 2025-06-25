package com.fancyshop.ecommerce.model;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import lombok.experimental.PackagePrivate;

import java.util.Set;
@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String imageUrl;
    private Integer quantity;    
    
    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;

        
    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    public Long getId(){return id;};
    public void setId(Long id){this.id = id;}

    public String getName(){return name;}
    public void setName(String name){this.name = name;}

    public double getPrice(){return price;}
    public void setPrice(Double price){this.price = price;}

    public Integer getQuantity(){return quantity;}
    public void setQuantity(Integer quantity){this.quantity = quantity;}

    public Order getOrder(){ return order;}
    public void setOrder(Order order){this.order = order;}

    public Product getProduct(){return product;}
    public void setProduct(Product product){this.product = product;}
    // public Set<Product> getProducts() { return products; }
    // public void setProducts(Set<Product> products) { this.products = products; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

}
