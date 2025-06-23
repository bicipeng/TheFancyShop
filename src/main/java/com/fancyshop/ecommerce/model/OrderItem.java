package com.fancyshop.ecommerce.model;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Table(name ="orders")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // how many items
    private Integer quantity;
    private Double price;
// one order has many items  
    @ManyToOne
    @JoinColumn(name ="order_id")
    private Order order;
// the same product could be order many times, 
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @OneToMany(mappedBy ="order", cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems;

    public Long getId() {return id;}
    public void setId(Long id){this.id =id;}

    public Integer getQuantity(){return quantity;}
    public void setQuantity(Integer quantity){this.quantity = quantity;}

    public Double getPric(){return price;}
    public void setPrice(Double price){this.price = price;}

    public Product getProduct (){return product;}
    public void setProduct(Product product){this.product = product;}

    public Order getOrder(){return order;}
    public void setOrder(Order order){this.order= order;}

    
}