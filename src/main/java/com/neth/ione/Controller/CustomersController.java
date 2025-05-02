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

    // "/customer"
    @GetMapping
    public String showCustomersPage(Model model) {
        model.addAttribute("customerList", customersService.getAllCustomers());
        return "customers";
    }

    // form
    @GetMapping("/add")
    public String showAddForm(Model model){
        model.addAttribute("customer", new Customers());
        //title when adding
        model.addAttribute("pageTitle", "Add New Customer");
        return "add-customer";
    }

    // both add and update
    @PostMapping("/save")
    public String addNewCustomer(@ModelAttribute("customer") Customers customers){
        customersService.saveCustomers(customers);
         return "redirect:/customers";
    }

    // 'view' button on the customer page
    @GetMapping("/details/{id}")
    public String viewCustomer(@PathVariable int id, Model model) {
        Customers customer = customersService.getCustomerById(id);
        model.addAttribute("customer", customer);
        return "customer-details"; // the name of the HTML file
    }

    // 'edit' button on the customer page (with already filled form)
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model) {
        Customers customer = customersService.getCustomerById(id);
        model.addAttribute("customer", customer);
        //title when editing
        model.addAttribute("pageTitle", "Edit Customer");
        return "add-customer";
    }

    // todo: delete
    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable int id) {
        customersService.deleteCustomer(id);
        return "redirect:/customers";
    }

// todo: fix page title name change of edit and new

}
