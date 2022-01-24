package com.exam.pariksha.services;

import com.exam.pariksha.model.Exam.Category;
import org.springframework.stereotype.Component;

import java.util.Set;


public interface CategoryService {

    public Category addCategory(Category category);
    public Set<Category> getCategories();
    public Category getCategoryById(Long cid);
    public Category updateCategory(Category category);
    public void deletCategory(Long cid);
}
