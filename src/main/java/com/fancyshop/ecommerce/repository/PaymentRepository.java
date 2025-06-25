package com.fancyshop.ecommerce.repository;

import com.fancyshop.ecommerce.model.OrderItem;
import com.fancyshop.ecommerce.model.Payment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    List<Payment> findByOrderId(Long orderId);
    Payment findByStripePaymentId(String stripePaymentId);
}
