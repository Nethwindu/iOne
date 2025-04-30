package com.neth.ione.Controller;

import com.neth.ione.Model.Items;
import com.neth.ione.Model.TempInvoiceItems;
import com.neth.ione.Service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/invoice")
public class InvoiceController {
    @Autowired
    private ItemsService itemsService;

    // Temporary invoice table items
    private List<TempInvoiceItems> tempInvoiceItems = new ArrayList<>();

    @GetMapping
    public String showInvoicePage(Model model) {
        List<Items> itemList = itemsService.getAllItems();
        model.addAttribute("items", itemList);

        // Send temporary invoice table items
        model.addAttribute("tempItems", tempInvoiceItems);

        return "invoice";
    }

    // after pressinf add itms
    @PostMapping("/add")
    public String addItemToInvoice(@RequestParam("item") int itemId,
                                   @RequestParam("quantity") int quantity,
                                   Model model) {

        Optional<Items> optionalItem = itemsService.getItemById(itemId);

        if (optionalItem.isPresent()) {
            Items selectedItem = optionalItem.get();

            // Now you can safely use selectedItem to create TempInvoiceItems
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
            // Handle case where item is not found
            System.out.println("Item not found with ID: " + itemId);
            // Optionally show an error message in the UI
        }


        tempInvoiceItems.add(tempItems);

        model.addAttribute("items", itemsService.getAllItems());
        model.addAttribute("tempItems", tempInvoiceItems);

        return "invoice";
    }


}
