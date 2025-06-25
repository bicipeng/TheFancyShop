package com.fancyshop.ecommerce.controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.fancyshop.ecommerce.model.Payment;
import com.fancyshop.ecommerce.repository.PaymentRepository;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/payments")
@CrossOrigin(origins = "http://localhost:3000") // Adjust the origin as
public class PaymentController {
    private final PaymentRepository paymentRepository;

    public PaymentController(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @GetMapping
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }
// get payment for id 
    @GetMapping("/{id}")
    public Optional<Payment> getPaymentById(@PathVariable Long id) {
        return paymentRepository.findById(id);
    }

    // get all payments for a specific order
    @GetMapping("/order/{orderId}")
    public List<Payment> getPaymentsByOrderId(@PathVariable Long orderId) {
        return paymentRepository.findByOrderId(orderId);
    }

    @GetMapping("/stripe/{stripePaymentId}")
    public Payment getPaymentByStripePaymentId(@PathVariable String stripePaymentId) {
        return paymentRepository.findByStripePaymentId(stripePaymentId);
    }

    @PostMapping
    public Payment createPayment(@RequestBody Payment payment) {
        payment.setTimestamp(LocalDateTime.now());
        return paymentRepository.save(payment);
    }

    @DeleteMapping("/{id}")
    public void deletePayment(@PathVariable Long id) {
        paymentRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public Payment updatePayment(@PathVariable Long id, @RequestBody Payment paymentDetails) {
        Payment payment = paymentRepository.findById(id).orElseThrow();
        payment.setAmount(paymentDetails.getAmount());
        payment.setCurrency(paymentDetails.getCurrency());
        payment.setStatus(paymentDetails.getStatus());
        payment.setTimestamp(LocalDateTime.now());
        payment.setStripePaymentId(paymentDetails.getStripePaymentId());
        return paymentRepository.save(payment);
    }

}
