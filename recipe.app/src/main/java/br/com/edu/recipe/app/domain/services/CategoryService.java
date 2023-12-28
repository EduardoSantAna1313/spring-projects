/* (C)2023 */
package br.com.edu.recipe.app.domain.services;

import br.com.edu.recipe.app.domain.model.Category;
import br.com.edu.recipe.app.domain.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

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
