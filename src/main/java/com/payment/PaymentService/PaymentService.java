package com.payment.PaymentService;

import jakarta.transaction.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Slf4j
@Controller
@RequestMapping("/test")
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    @GetMapping("/payments/{id}")
    public ResponseEntity<?> getPayment(@PathVariable Long id) {
      //  log.debug("In getPayment()... id = " + id);
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if (optionalPayment.isPresent()) {
            return ResponseEntity.ok(optionalPayment.get());
        } else {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Payment with ID " + id + " not found");
        }
    }

    @GetMapping("/payments")
    public ResponseEntity<List<Payment>> listPayments() {
     //   log.debug("In listPayments()...");
        List<Payment> paymentList = paymentRepository.findAll();
        return ResponseEntity.ok(paymentList);
    }

    @Transactional
    @PostMapping("/payments")
    public ResponseEntity<Payment> savePayment(@RequestBody Payment payment) {
      //  log.debug("In savePayment()...");
        paymentRepository.save(payment);
        return ResponseEntity.ok(payment);
    }

    @Transactional
    @PutMapping("/payments/{id}")
    public ResponseEntity<?> updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
   //     log.debug("In updatePayment()... id = " + id);
        Optional<Payment> optionalPayment = paymentRepository.findById(id);
        if (optionalPayment.isPresent()) {
            Payment databasePayment = optionalPayment.get();
            databasePayment.setOrderId(payment.getOrderId());
            databasePayment.setPaymentDate(payment.getPaymentDate());
            databasePayment.setPaymentType(payment.getPaymentType());
            databasePayment.setAmount(payment.getAmount());
            databasePayment.setCustomerId(payment.getCustomerId());
            databasePayment.setEmployeeId(payment.getEmployeeId());
            databasePayment.setTransactionId(payment.getTransactionId());
            return ResponseEntity.ok(optionalPayment.get());
        } else {
            return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body("Payment with ID " + id + " not found");
        }
    }

    @Transactional
    @DeleteMapping("/payments/{id}")
    public ResponseEntity<String> deletePayment(@PathVariable Long id) {
   //     log.debug("In deletePayment()... id = " + id);
        Optional<Payment> optionalPayment = paymentRepository.findById(id);

        if (optionalPayment.isPresent()) {
            paymentRepository.delete(optionalPayment.get());
            return ResponseEntity.status(HttpStatus.OK)
                .body("Payment with ID " + id + " deleted!");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body("Payment with ID " + id + " not found");
        }
    }

    @Transactional
    @PostMapping("/payments/setup")
    public ResponseEntity<String> setup() {
        paymentRepository.save(new Payment(1L, new Date(), "Credit Card",
            new BigDecimal("100.00"), 1L, 101L, "TXN12345"));
        paymentRepository.save(new Payment(2L, new Date(), "Debit Card",
            new BigDecimal("50.00"), 2L, 102L, "TXN67890"));
        // Add more payment records as needed
        return ResponseEntity.ok("Added payment records!");
    }

    @Transactional
    @PostMapping("/payments/reset")
    public ResponseEntity<String> reset() {
        paymentRepository.deleteAll();
        return ResponseEntity.ok("All payment records deleted!");
    }
}
