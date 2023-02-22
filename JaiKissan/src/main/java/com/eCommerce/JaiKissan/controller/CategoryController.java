package com.eCommerce.JaiKissan.controller;

import com.eCommerce.JaiKissan.Entities.Category;
import com.eCommerce.JaiKissan.Exception.NotFoundException;
import com.eCommerce.JaiKissan.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ecommerce")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

   @PostMapping("/save")
    public Category addCalegory(@RequestBody Category productCategory){
        return this.categoryService.addCalegory(productCategory);
    }
    @GetMapping("/getCat")
    public List<Category> getCategory(){
       return (List<Category>) this.categoryService.getCat();
    }
    @DeleteMapping("/deleteCat/{id}")
    public void deleteCat(@PathVariable int id){
       categoryService.deleteCat(id);
    }
    @GetMapping("/getIDCat/{id}")
    public Category getCatById(@PathVariable int id) throws NotFoundException {
       return categoryService.getByIDCat(id);
    }


    @PutMapping("/updateCataegory/{id}")
    public Category updateCat(@PathVariable int id,@RequestBody Category category){
       return this.categoryService.updateCat(id, category);
    }
}
