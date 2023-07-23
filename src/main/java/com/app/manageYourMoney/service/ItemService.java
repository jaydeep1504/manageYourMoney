package com.app.manageYourMoney.service;

import com.app.manageYourMoney.data.entity.ItemDetails;
import com.app.manageYourMoney.data.entity.UserDetails;
import com.app.manageYourMoney.data.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    
    public void saveItem(ItemDetails itemDetails){
        itemRepository.save(itemDetails);
    }

    public List<ItemDetails> getAllItems(){
        return itemRepository.findAll();
    }

    public void deleteItemById(int id){
        itemRepository.deleteById(id);
    }

    public ItemDetails getItemById(int id){
        return itemRepository.getReferenceById(id);
    }
}
