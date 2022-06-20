package br.com.edu.recipe.app.services;

import br.com.edu.recipe.app.domain.Category;
import br.com.edu.recipe.app.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category get(String description) {
        return categoryRepository.findByDescription(description).get();
    }


}
