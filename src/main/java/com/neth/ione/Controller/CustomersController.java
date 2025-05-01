package com.neth.ione.Controller;

import com.neth.ione.Model.Customers;
import com.neth.ione.Service.CustomersService;
import com.neth.ione.Service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/customers")
public class CustomersController {

    @Autowired
    private CustomersService customersService;

    @GetMapping
    public String showCustomersPage(Model model) {
        model.addAttribute("customerList", customersService.getAllCustomers());
        return "customers";
    }

    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("customer", new Customers());
        return "add-customer";
    }

    @PostMapping("/save")
    public String addNewCustomer(@ModelAttribute("customer") Customers customers){
        customersService.saveCustomers(customers);
         return "redirect:/customers";
    }

    @GetMapping("/details/{id}")
    public String viewCustomer(@PathVariable int id, Model model) {
        Customers customer = customersService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "customer-details"; // the name of the HTML file
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Customers customer = customersService.getCustomerById(id);
        model.addAttribute("customer", customer); // Pre-fill the form with this customer
        return "add-customer"; // Use the same form as adding a new customer
    }



}
