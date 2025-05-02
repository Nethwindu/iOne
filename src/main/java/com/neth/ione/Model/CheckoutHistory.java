package com.neth.ione.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class CheckoutHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double grandTotal;
    private double amountPaid;
    private double balance;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customers customer;

    private LocalDateTime checkoutTime;
}
