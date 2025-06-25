package com.fancyshop.ecommerce.controller;

import com.fancyshop.ecommerce.model.OrderHistory;
import com.fancyshop.ecommerce.repository.OrderHistoryRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/order-history")
@CrossOrigin(origins = "http://localhost:3000") // Adjust the origin as
public class OrderHistoryController {
    private final OrderHistoryRepository orderHistoryRepository;
  
    public OrderHistoryController(OrderHistoryRepository orderHistoryRepository, UserRepository userRepository, RoleRepository roleRepository) {
        this.orderHistoryRepository = orderHistoryRepository;
    }

    @GetMapping
    public List<OrderHistory> getAllOrderHistories() {
        return orderHistoryRepository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<OrderHistory> getOrderHistoryById(@PathVariable Long id) {
        return orderHistoryRepository.findById(id);
    }

    @PostMapping
    public OrderHistory createOrderHistory(@RequestBody OrderHistory orderHistory) {
        return orderHistoryRepository.save(orderHistory);
    }

    @DeleteMapping("/{id}")
    public void deleteOrderHistory(@PathVariable Long id) {
        orderHistoryRepository.deleteById(id);
    }
}
