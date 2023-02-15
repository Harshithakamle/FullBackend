package com.FullBackend.controllers;

import com.FullBackend.payloads.CategoryDto;
import com.FullBackend.services.CategoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private CategoryService catService;

    public CategoryController(CategoryService catService) {
        this.catService = catService;
    }
    @PostMapping("/")
    public ResponseEntity<CategoryDto> createCategory(@Valid @RequestBody CategoryDto catDto){
        CategoryDto category = catService.createCategory(catDto);

    return new ResponseEntity<>(category, HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateTheCategory(@Valid @PathVariable("id") long id,@RequestBody CategoryDto catDto){
        CategoryDto categoryDto = catService.updateCategory(catDto, id);
      return new ResponseEntity<>(categoryDto, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTheCategory(@PathVariable("id") long id){
        catService.deleteCategory(id);
        return new ResponseEntity("Category Deleted successfully", HttpStatus.OK);
    }
    @GetMapping("/allCats")
    public ResponseEntity<List<CategoryDto>> getAllCats(){
        List<CategoryDto> allCats = catService.getAll();
        return ResponseEntity.ok(allCats);
    }
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getOneCategoryById(@PathVariable("id")long id){
        CategoryDto oneCat = catService.getCategory(id);
        return new ResponseEntity<>(oneCat, HttpStatus.OK);
    }
}
