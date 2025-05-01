package com.neth.ione.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;


import java.time.LocalDate;

@Data
@Entity
@Table(name = "customers")
@NoArgsConstructor
@AllArgsConstructor
public class Customers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;
    private String firstName;
    private String lastName;
    private String company;
    private String email;
    private String phone;
    private String address;
    private LocalDate registerDate;
    @Enumerated(EnumType.STRING)
    private CustomerStatus status;



}
