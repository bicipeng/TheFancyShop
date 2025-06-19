package com.fancyshop.ecommerce.model;
import jakarta.persistence.*;
import lombok.experimental.PackagePrivate;

import java.util.Set;

import javax.management.relation.Role;
public class User {
    @Id
    // AUTO genterate the ID using the db's identity col
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    //  user has a many to many relationship with role
    @ManyToMany
    @JoinTable(name="roles", joinColumns = @JoinColumn(name="user_d"),
    inverseJoinColumns =@JoinColumn (name="role_id"))
    private Set<Role> roles;

    // user has many orders
    @OneToMany(mappedBy ="user")
    private Set<Order> orders;

    public Long getId() {return id;}
    public void setId(Long id){this.id = id;}

    public String getEmail(){return email;}
    public void setEmail(String email){this.email = email;}

    public String getFirstName(){return firstName;}
    public void setFirstName(String firstName){this.firstName = firstName;}

    public String getLastName(){return lastName;}
    public void setLastName(String lastName){this.lastName = lastName;}

    public String getPassword(){return password;}
    public void setPassword(String password){this.password = password;}

    public String getAddress(){return address;}
    public void setAddress(String address){this.address = address;}

    public String getPhoneNumber(){return phoneNumber;}
    public void setphoneNumber(String phoneNumber){this.phoneNumber = phoneNumber;}

    public Set<Role> getRoles() { return roles; }
    public void setRoles(Set<Role> roles) { this.roles = roles; }

    public Set<Order> getOrders() { return orders; }
    public void setOrders(Set<Order> orders) { this.orders = orders; }
    
}
