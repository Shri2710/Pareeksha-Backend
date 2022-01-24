package com.exam.pariksha.Controller;

import com.exam.pariksha.model.Exam.Category;
import com.exam.pariksha.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/category")
@CrossOrigin("*")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public Category addCategory(@RequestBody Category category){
        return this.categoryService.addCategory(category);
    }

    @GetMapping("/{categoryId}")
    public Category getCategoryById(@PathVariable("categoryId") Long cid){
        return this.categoryService.getCategoryById(cid);
    }

    @GetMapping("/")
    public Set<Category> getCategories(){
        return this.categoryService.getCategories();
    }

    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category){
        return this.categoryService.updateCategory(category);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long cid){
        this.categoryService.deletCategory(cid);
    }
}
