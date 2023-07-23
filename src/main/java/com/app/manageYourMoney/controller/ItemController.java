package com.app.manageYourMoney.controller;

import com.app.manageYourMoney.data.entity.ItemDetails;
import com.app.manageYourMoney.service.CategoryService;
import com.app.manageYourMoney.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;
    @Autowired
    private CategoryService categoryService;
    @GetMapping("/additem")
    public String addItem(Model model){
        model.addAttribute("categories",categoryService.getAllCategories());
        return "additem";
    }
    @PostMapping("/saveitem")
    public String saveItemDetails(@ModelAttribute ItemDetails itemDetails){
    	//System.out.println(itemDetails);
        itemService.saveItem(itemDetails);
        return "redirect:/getallitems";
    }

    @GetMapping("/getallitems")
    public String getAllItems(Model model){
    	//System.out.println(itemService.getAllItems());
        model.addAttribute("items",itemService.getAllItems());
        return "getallitems";
    }

    @GetMapping("/edititem/{id}")
    public String getItemById(@PathVariable int id,Model model){
        model.addAttribute("item",itemService.getItemById(id));
        model.addAttribute("categories", categoryService.getAllCategories());
        return "edititem";
    }

    @GetMapping("/deleteitem/{id}")
    public String deleteItemById(@PathVariable int id){
        itemService.deleteItemById(id);
        return "redirect:/getallitems";
    }
}
