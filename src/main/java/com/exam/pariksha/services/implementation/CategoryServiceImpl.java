package com.exam.pariksha.services.implementation;

import com.exam.pariksha.model.Exam.Category;
import com.exam.pariksha.repo.CategoryRepo;
import com.exam.pariksha.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class CategoryServiceImpl implements CategoryService {


    @Autowired
    private CategoryRepo categoryRepo;

    @Override
    public Category addCategory(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(this.categoryRepo.findAll());
    }

    @Override
    public Category getCategoryById(Long cid) {
        return this.categoryRepo.findById(cid).get();
    }

    @Override
    public Category updateCategory(Category category) {
        return this.categoryRepo.save(category);
    }

    @Override
    public void deletCategory(Long cid) {

        //Can be done in otherways also
        this.categoryRepo.deleteById(cid);

    }
}
