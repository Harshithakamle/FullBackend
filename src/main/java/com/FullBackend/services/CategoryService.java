package com.FullBackend.services;

import com.FullBackend.payloads.CategoryDto;

import java.util.List;

public interface CategoryService {
   CategoryDto createCategory(CategoryDto catDto);
   CategoryDto updateCategory(CategoryDto categoryDto,long categoryId);
   public void deleteCategory(long categoryId);
   public CategoryDto getCategory(long categoryId);

   public List<CategoryDto> getAll();


}
