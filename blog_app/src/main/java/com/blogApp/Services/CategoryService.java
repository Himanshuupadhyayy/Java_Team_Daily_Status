package com.blogApp.Services;

import com.blogApp.Payload.CategoryDto;

import java.util.List;

public interface CategoryService {

    CategoryDto createCategory(CategoryDto categoryDto);


    CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId);

    public void deleteCategory(Integer categoryId);

    CategoryDto getCategory(Integer categoryId);


    List<CategoryDto> getAllCate();

}
