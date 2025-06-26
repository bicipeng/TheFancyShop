package com.fancyshop.ecommerce.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String stripePaymentId;
    private Double amount;
    private String currency;
    private String status;
    private LocalDateTime timestamp;

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;

    public Long getId(){return id;}
    public void setId(Long id){this.id= id;}

    public String getStripePaymentId(){return stripePaymentId;}
    public void setStripePaymentId(String stripePaymentId){this.stripePaymentId= stripePaymentId;}

    public Double getAmount(){return amount;}
    public void setAmount(Double amount){this.amount= amount;}

    public String getCurrency(){return currency;}
    public void setCurrency(String currency){this.currency= currency;}

    public String getStatus() { return status; }
    public void setStatus(String status){this.status= status;}

    public LocalDateTime getTimestamp() { return timestamp; }
    public void setTimestamp(LocalDateTime timestamp) { this.timestamp = timestamp; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
}
