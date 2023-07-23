package com.app.manageYourMoney.controller;

import com.app.manageYourMoney.data.entity.Category;
import com.app.manageYourMoney.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/addcategory")
    public String addCategory(){
        return "addcategory";
    }
    @PostMapping("/savecategory")
    public String saveCategory(@ModelAttribute Category category){
        categoryService.saveCategory(category);
        return "redirect:/getallcategories";
    }

    @GetMapping("/getallcategories")
    public String getAllCategories(Model model){
        model.addAttribute("categories",categoryService.getAllCategories());
        return "getallcategories";
    }

    @GetMapping("/editcategory/{id}")
    public String getCategoryById(@PathVariable int id,Model model){
        model.addAttribute("category",categoryService.getCategoryById(id));
        return "editcategory";
    }

    @GetMapping("/deletecategory/{id}")
    public String deleteCategory(@PathVariable int id){
        categoryService.deleteCategoryById(id);
        return "redirect:/getallcategories";
    }
}
