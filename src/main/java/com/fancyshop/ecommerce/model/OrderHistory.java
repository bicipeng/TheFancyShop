package com.fancyshop.ecommerce.model;
import jakarta.persistence.*;
import lombok.experimental.PackagePrivate;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
public class OrderHistory {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Long id;
private String status;
private LocalDateTime createAt;
// state of the order change from pending /paid and shipped
private LocalDateTime changedAt;

//relationship to order entity
@ManyToOne
@JoinColumn(name = "order_id")
private Order order;

public Long getId(){return id;}
public void setId(Long id){this.id = id;}

public String getStatus(){return status;}
public void setStatus(String status){this.status = status;}

public LocalDateTime getCreateAt(){return createAt;}
public void setCreateAt (LocalDateTime createAt){this.createAt = createAt;}

public LocalDateTime getChangeAt(){return changedAt;}
public void setChangeAt (LocalDateTime changedAt){this.changedAt = changedAt;}

public Order getOrder(){return order;}
public void setOrder(Order order){this.order = order;}

}
