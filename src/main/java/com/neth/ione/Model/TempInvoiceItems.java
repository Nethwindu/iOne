package com.neth.ione.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TempInvoiceItems {
    private int itemId;
    private String model;
    private String color;
    private String Storage;
    private double price;
    private int quantity;
    private double total;


}
