package com.FullBackend.services.serviceImpl;

import com.FullBackend.entities.Category;
import com.FullBackend.exceptions.ResourceNotFoundException;
import com.FullBackend.payloads.CategoryDto;
import com.FullBackend.repositories.CategoryRepository;
import com.FullBackend.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository catRepo;

    private ModelMapper modelMapper;

    public CategoryServiceImpl(CategoryRepository catRepo, ModelMapper modelMapper) {
        this.catRepo = catRepo;
        this.modelMapper = modelMapper;
    }

    @Override
    public CategoryDto createCategory(CategoryDto catDto) {
        Category cat = modelMapper.map(catDto, Category.class);
        Category save = catRepo.save(cat);
        return modelMapper.map(save,CategoryDto.class);
    }

    @Override
    public CategoryDto updateCategory(CategoryDto categoryDto, long categoryId) {
        Category category = catRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "id", categoryId));
        category.setCategoryTitle(categoryDto.getCategoryTitle());
        category.setCategoryDesciption(categoryDto.getCategoryDesciption());
        Category save = catRepo.save(category);
        return modelMapper.map(save,CategoryDto.class);
    }
//categoryDesciption
    @Override
    public void deleteCategory(long categoryId) {
        Category category = catRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "id", categoryId));
    catRepo.delete(category);
    }

    @Override
    public CategoryDto getCategory(long categoryId) {
        Category category = catRepo.findById(categoryId).orElseThrow(() -> new ResourceNotFoundException("category", "id", categoryId));

        return modelMapper.map(category,CategoryDto.class);
    }

    @Override
    public List<CategoryDto> getAll() {
        List<Category> all = catRepo.findAll();
        List<CategoryDto> collect = all.stream().map((cat) -> modelMapper.map(cat, CategoryDto.class)).collect(Collectors.toList());
        return collect;
    }
}
