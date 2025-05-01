package com.neth.ione.Controller;

import com.neth.ione.Model.Items;
import com.neth.ione.Model.TempInvoiceItems;
import com.neth.ione.Service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private ItemsService itemsService;

    // temporary invoice table items list
    private List<TempInvoiceItems> tempInvoiceItems = new ArrayList<>();



    @GetMapping
    public String showInvoicePage(Model model) {
        List<Items> itemList = itemsService.getAllItems();
        // send all items list to the invoice page for the dropdown list
        model.addAttribute("items", itemList);

        // send temporary invoice table items list to the invoice page
        model.addAttribute("tempItems", tempInvoiceItems);

        //grand total
        double grandTotal = 0.0;
        for (TempInvoiceItems item : tempInvoiceItems) {
            grandTotal += item.getTotal(); // add each item's total to grandTotal
        }
        model.addAttribute("grandTotal", grandTotal);

        //balance and amount paid
        double balance;
        double amountPaid = 0.0;
        balance = grandTotal - amountPaid;
        model.addAttribute("balance", balance);
        model.addAttribute("amountPaid", amountPaid);


        return "invoice";
    }

    // after the submition - add item
    @PostMapping("/add")
    public String addItemToInvoice(@RequestParam("itemId") int itemId, @RequestParam("quantity") int quantity, Model model) {

        Optional<Items> optionalItem = itemsService.getItemById(itemId);

        if (optionalItem.isPresent()) {
            Items selectedItem = optionalItem.get();

            TempInvoiceItems temp = new TempInvoiceItems();

            temp.setItemId(selectedItem.getId());
            temp.setModel(selectedItem.getModel());
            temp.setColor(selectedItem.getColor());
            temp.setStorage(selectedItem.getStorage());
            temp.setPrice(selectedItem.getPrice());
            temp.setQuantity(quantity);
            temp.setTotal(selectedItem.getPrice() * quantity);

            tempInvoiceItems.add(temp);

        } else {
            System.out.println("Item not found with ID: " + itemId);
        }

        model.addAttribute("items", itemsService.getAllItems());
        model.addAttribute("tempItems", tempInvoiceItems);


        return "redirect:/invoice";
    }

// todo: delete item from invoice
    @GetMapping("/delete/{itemId}")
    public String deleteItemFromInvoice(@PathVariable("itemId") int itemId, Model model) {
        // find the item with the matching itemId and remove it from the tempInvoiceItems list
        tempInvoiceItems.removeIf(item -> item.getItemId() == itemId);
        //todo: solve refresh problem
        return "redirect:/invoice";
    }

}

// todo: update invoice total
