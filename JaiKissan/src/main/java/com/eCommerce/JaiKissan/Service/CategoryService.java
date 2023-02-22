package com.eCommerce.JaiKissan.Service;

import com.eCommerce.JaiKissan.Entities.Category;
import com.eCommerce.JaiKissan.Exception.NotFoundException;
import com.eCommerce.JaiKissan.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public Category addCalegory(Category productCategory){
        return this.categoryRepository.save(productCategory);
    }

    public List<Category> getCat() {
        return this.categoryRepository.findAll();
    }

    public void deleteCat(int id) {
        Category category= categoryRepository.getById(id);
        categoryRepository.delete(category);
    }


    public Category getByIDCat(int id) throws NotFoundException {
        Category category = categoryRepository.findById(id).get();

        if (category != null) {
            return category;
        }else{
            throw new NotFoundException("category not found with id : "+id);
        }

    }

    public Category updateCat(int id, Category category) {
        category.setId(id);
        return this.categoryRepository.save(category);
    }
}
