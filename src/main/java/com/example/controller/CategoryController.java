package com.example.controller;

import com.example.dto.CategoryDto;
import com.example.entity.Category;
import com.example.repository.CategoryRepository;
import com.example.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;
    private final CategoryRepository repository;

    @GetMapping({"/", "/index"})
    public String viewHomePage(Model model) {
        model.addAttribute("categoryList", categoryService.getAllCategories());
        return "index";
    }

    @GetMapping("/addNew")
    public String addNewEmployee(Model model) {
        CategoryDto category = new CategoryDto();
        model.addAttribute("category", category);
        return "newCategory";
    }

    @PostMapping("/save")
    public String saveEmployee(@ModelAttribute("categoryDto") CategoryDto category) {
        categoryService.addCategory(category);
        return "redirect:/";
    }

    @GetMapping("/showFormForUpdate/{id}")
    public String updateForm(@PathVariable(value = "id") Integer id, Model model) {
        Category categoryDto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found id :" + id));
        model.addAttribute("category", categoryDto);
        return "update";
    }

    @GetMapping("/deleteEmployee/{id}")
    public String deleteThroughId(@PathVariable(value = "id") Integer id) {
        categoryService.deleteCategory(id);
        return "redirect:/";

    }
}
