package com.neth.ione.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Entity
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "model_id", nullable = false)
    private Model model;

    @ManyToOne
    @JoinColumn(name = "color_id", nullable = false)
    private Color color;

    @ManyToOne
    @JoinColumn(name = "storage_id", nullable = false)
    private Storage storage;

    @Column(nullable = false)
    private BigDecimal price;
//r
}
