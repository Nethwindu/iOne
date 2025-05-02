package com.neth.ione.Controller;

import com.neth.ione.Model.Items;
import com.neth.ione.Service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    // ADD NEW ITEMS PAGE
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("item", new Items());
        return "items/add-item";
    }

    // AFTER HITTING SUBMIT
    @PostMapping("/add")
    public String addNewItem(@ModelAttribute("item") Items item) {
        itemsService.saveItem(item);
        return "redirect:/items/all";
    }

    // ITEMS PAGE
    @GetMapping("/all")
    public String viewItemsList(Model model) {
        model.addAttribute("itemsList", itemsService.getAllItems());
        return "items/items";
    }

    // EDITING ITEM
    @GetMapping("/edit/{id}")
    public String editItem(@PathVariable int id, Model model) {
        Items item = itemsService.getItemById(id).orElse(null);
        model.addAttribute("item", item);
        return "items/add-item";
    }

    // DELETING ITEM
    @GetMapping("/delete/{id}")
    public String deleteItem(@PathVariable int id) {
        itemsService.deleteItem(id);
        return "redirect:/items/all";
    }




}
