package com.fancyshop.ecommerce.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;
@Entity
@Table(name ="orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime orderTime;
    private Double total;
    // need to join with user, one user can has many orders
    // one order can only belongs to one user
    @ManyToOne
    @JoinColumn(name ="user_id")
    private User user;

    @OneToMany(mappedBy ="order", cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems;

    public Long getId() {return id;}
    public void setId(Long id){this.id =id;}

    public LocalDateTime getOrderTime(){return orderTime;}
    public void setOrderTime(LocalDateTime orderTime){this.orderTime = orderTime;}

    public Double getTotal(){return total;}
    public void setTotal(Double total){this.total = total;}

    public User getUser(){return user;}
    public void setUser(User user){this.user = user;}

    public Set<OrderItem> getOrderItems(){return orderItems;}
    public void setOrderItems(Set<OrderItem> orderItems){this.orderItems = orderItems;}

    
}
