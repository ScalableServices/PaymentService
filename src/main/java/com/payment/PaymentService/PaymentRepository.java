package com.payment.PaymentService;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PaymentRepository extends JpaRepository<Payment, Long> {
    // Spring Data JPA provides basic CRUD operations by default
	
}
