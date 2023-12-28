/* (C)2023 */
package br.com.edu.recipe.app.domain;

import static org.junit.Assert.*;

import br.com.edu.recipe.app.domain.model.Category;
import org.junit.Before;
import org.junit.Test;

public class CategoryTest {

    Category category;

    @Before
    public void setUp() throws Exception {
        category = new Category();
    }

    @Test
    public void getId() {
        Long id = 4l;
        category.setId(id);
        assertEquals(id, category.getId());
    }

    @Test
    public void getDescription() {}

    @Test
    public void getRecipes() {}
}
