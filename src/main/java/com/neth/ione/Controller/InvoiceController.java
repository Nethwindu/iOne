package com.neth.ione.Controller;

import com.neth.ione.Model.CheckoutHistory;
import com.neth.ione.Model.Customers;
import com.neth.ione.Model.Items;
import com.neth.ione.Model.TempInvoiceItems;
import com.neth.ione.Repository.CheckoutHistoryRepo;
import com.neth.ione.Service.CheckoutHistoryService;
import com.neth.ione.Service.CustomersService;
import com.neth.ione.Service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {

    @Autowired
    private ItemsService itemsService;
    @Autowired
    private CustomersService customersService;
    @Autowired
    private CheckoutHistoryService checkoutHistoryService;
    @Autowired
    private CheckoutHistoryRepo checkoutHistoryRepo;
//    @Autowired
//    private CheckoutHistory checkoutHistory;


    // temporary invoice table items list
    private List<TempInvoiceItems> tempInvoiceItems = new ArrayList<>();

    double amountPaid = 0.0;
    private String checkoutTime = null;

    // todo: not sure comebak later
    private int selectedCustomerId = -1;



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

        balance = amountPaid - grandTotal;
        model.addAttribute("balance", balance);
        model.addAttribute("amountPaid", amountPaid);


        //handling null of datetime
        if (checkoutTime != null) {
            model.addAttribute("checkoutTime", checkoutTime);
        } else {
            model.addAttribute("checkoutTime", " ~");
        }

        // CUTOMER DROPDOWN
        List<Customers> customersList = customersService.getAllCustomers();
        model.addAttribute("customersList", customersList);

        // passing the selected customerId to keep it selected
        model.addAttribute("selectedCustomerId", selectedCustomerId);

        return "invoice/invoice";
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

    @PostMapping("/updateAmountPaid")
    public String updateAmountPaid(@RequestParam("amountPaid") double amountPaid,@RequestParam("customerId") int customerId,  Model model) {
        this.amountPaid = amountPaid;  // store the amount paid in the controller

        //selected part
        this.selectedCustomerId = customerId;

        // recalculating the grand total
        double grandTotal = 0.0;
        for (TempInvoiceItems item : tempInvoiceItems) {
            grandTotal += item.getTotal();  // Add up each item's total cost
        }

        // balace calulating again : balance = grandTotal - amountPaid
        double balance = amountPaid - grandTotal;

        // Add the updated values to the model so they can be displayed on the page
        model.addAttribute("grandTotal", grandTotal);
        model.addAttribute("balance", balance);
        model.addAttribute("amountPaid", amountPaid);
        model.addAttribute("tempItems", tempInvoiceItems);

        //date and time
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        this.checkoutTime = now.format(formatter);


        //to the invoice page with updated values
        return "redirect:/invoice";


    }

    // after hitting checkout
    @PostMapping("/checkout")
    public String finalizeCheckout() {
        double grandTotal = 0.0;
        for (TempInvoiceItems item : tempInvoiceItems) {
            grandTotal += item.getTotal();
        }

        double balance = amountPaid - grandTotal;

        // get the selected customer
        Customers customer = customersService.getCustomerById(selectedCustomerId);

        // convert checkoutTime string back to LocalDateTime
        LocalDateTime checkoutDateTime = LocalDateTime.parse(checkoutTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        // Save to DB
        checkoutHistoryService.saveCheckout(grandTotal, amountPaid, balance, customer, checkoutDateTime);

        // clear all after checkout
        tempInvoiceItems.clear();
        amountPaid = 0.0;
        selectedCustomerId = -1;
        checkoutTime = null;

        return "checkout/success";
    }

    @GetMapping("/history")
    public String getCheckoutHistory(Model model) {
        // getting values from checkoutHistory
        List<CheckoutHistory> checkoutHistoryList = checkoutHistoryRepo.findAll();

        model.addAttribute("checkoutHistoryList", checkoutHistoryList);

        return "checkout/history";
    }






}

// todo: comma prob
