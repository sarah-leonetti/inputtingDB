package com.iaustin.ggsapi.rest;

import com.iaustin.ggsapi.mapper.CategoryMapper;
import com.iaustin.ggsapi.model.Category;
//import com.iaustin.ggsapi.rest.dto.CreateCategoryRequest;
import com.iaustin.ggsapi.rest.dto.CategoryDto;
import com.iaustin.ggsapi.rest.dto.CreateCategoryRequest;
import com.iaustin.ggsapi.rest.dto.UpdateCategoryRequest;
import com.iaustin.ggsapi.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

import static com.iaustin.ggsapi.config.SwaggerConfig.BEARER_KEY_SECURITY_SCHEME;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryMapper categoryMapper;

    @Operation(security = { @SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME) })
    @GetMapping
    public List<CategoryDto> readCategories(@RequestParam(value = "id", required = false) Long id) {
        List<Category> categorys = (id == null) ? categoryService.getCategories() : categoryService.getCategories(id);
        return categorys.stream()
                .map(categoryMapper::toCategoryDto)
                .collect(Collectors.toList());
    }

    @Operation(security = { @SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME) })
    @PutMapping()
    public CategoryDto updateCategory(@Valid @RequestBody UpdateCategoryRequest updateCategory) {
        Category category = categoryService.validateAndGetCategory(updateCategory.getId());
        category.setName(updateCategory.getName());
        category.setParentId(updateCategory.getParentId());
        category.setRank(updateCategory.getRank());
        categoryService.saveCategory(category);
        return categoryMapper.toCategoryDto(category);
    }

    @Operation(security = { @SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME) })
    @DeleteMapping("/{id}")
    public CategoryDto deleteCategory(@PathVariable Long id) {
        Category category = categoryService.validateAndGetCategory(id);
        categoryService.deleteCategory(category);
        return categoryMapper.toCategoryDto(category);
    }

    @Operation(security = { @SecurityRequirement(name = BEARER_KEY_SECURITY_SCHEME) })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public CategoryDto createCategory(@Valid @RequestBody CreateCategoryRequest createRequest) {
        Category category = categoryMapper.createToCategory(createRequest);
        category = categoryService.saveCategory(category);
        return categoryMapper.toCategoryDto(category);
    }
}
