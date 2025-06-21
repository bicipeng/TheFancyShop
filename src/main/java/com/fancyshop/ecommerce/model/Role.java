package com.fancyshop.ecommerce.model;
import jakarta.persistence.*;
import lombok.experimental.PackagePrivate;
import java.util.Set;

public class Role{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Long getId(){return id;}
    public void setId(Long id){this.id = id;}
    
    public String getName(){return name;}
    public void setName(String name){this.name = name;}


}
