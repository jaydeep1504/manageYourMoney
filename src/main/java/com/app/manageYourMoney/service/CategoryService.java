package com.app.manageYourMoney.service;

import com.app.manageYourMoney.data.entity.Category;
import com.app.manageYourMoney.data.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    public void saveCategory(Category category){
        categoryRepository.save(category);
    }

    public void deleteCategoryById(int id){
        categoryRepository.deleteById(id);
    }

    public Category getCategoryById(int id){
        return categoryRepository.getReferenceById(id);
    }

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

}
