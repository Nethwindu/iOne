package com.neth.ione.Controller;

import com.neth.ione.Model.Items;
import com.neth.ione.Service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private ItemsService itemsService;

    @GetMapping
    public String showInvoicePage(Model model) {
        List<Items> itemList = itemsService.getAllItems(); // get items
        model.addAttribute("items", itemList);             // send to HTML
        return "invoice";                                  // show invoice.html
    }
}
