package com.neth.ione.Controller;

import com.neth.ione.Service.ItemsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/items")
public class ItemsController {
    @Autowired
    private ItemsService itemsService;

    @RequestMapping("/add")
    public String addNewItem() {
        return "add-item";
    }
}
