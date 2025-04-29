package com.neth.ione.Service;

import com.neth.ione.Model.Items;
import com.neth.ione.Repository.ItemsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemsService {
    @Autowired
    private ItemsRepo itemsRepo;

    // SAVING OR UPDATING AN ITEM
    public Items saveItem(Items item) {
        return itemsRepo.save(item);
    }

    // FIND ALL ITEMS
    public List<Items> getAllItems() {
        return itemsRepo.findAll();
    }

    public Optional<Items> getItemById(int id) {
        return itemsRepo.findById(id);
    }

    // DELETE AN ITEM BY ID
    public void deleteItem(int id){
        itemsRepo.deleteById(id);
    }


}
