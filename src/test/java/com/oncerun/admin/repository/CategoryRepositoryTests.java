package com.oncerun.admin.repository;

import com.oncerun.admin.AdminApplicationTests;
import com.oncerun.admin.domain.entity.Category;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CategoryRepositoryTests  extends AdminApplicationTests {


    @Autowired
    private CategoryRepository categoryRepository;

    @Test
    void create(){

        String type = "COMPUTER";
        String title = "컴퓨터";
        LocalDateTime createdAt = LocalDateTime.now();
        String createdBy = "AdminServer";

        Category category = new Category();
        category.setType(type);
        category.setTitle(title);
        category.setCreatedAt(createdAt);
        category.setCreatedBy(createdBy);


        Category newCategory = categoryRepository.save(category);

        assertNotNull(newCategory);

    }


    @Test
    void read(){

        Optional<Category> categoryOptional = categoryRepository.findByType("COMPUTER");

        categoryOptional.ifPresent( c -> {
            System.out.println(c.getId());
            System.out.println(c.getType());
            System.out.println(c.getTitle());
        });
    }
}
