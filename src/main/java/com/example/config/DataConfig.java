package com.example.config;

import com.example.entity.Category;
import com.example.entity.SubCategory;
import com.example.repository.CategoryRepository;
import com.example.service.CategoryService;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Log4j2
public class DataConfig {

    @Bean
    public CommandLineRunner run(CategoryRepository repository, CategoryService service) {
        return (message) -> {
            SubCategory subCategory1 = SubCategory.builder().name("Red").build();
            SubCategory subCategory2 = SubCategory.builder().name("Green").build();
            Category category = Category.builder().name("Color")
                    .subCategories(List.of(subCategory1, subCategory2)).build();
            repository.save(category);
            log.info("Saved initial date: " + service.getAllCategories());
        };
    }
}
