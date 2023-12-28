/* (C)2023 */
package br.com.edu.recipe.app.repositories;

import static org.junit.Assert.*;

import br.com.edu.recipe.app.domain.model.UnitOfMeasure;
import br.com.edu.recipe.app.domain.repositories.UnitOfMeasureRepository;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryIT {

    @Autowired
    UnitOfMeasureRepository repository;

    @Before
    public void setUp() throws Exception {}

    @Test
    @DirtiesContext
    public void findByDescriptionTeaspoon() {

        var op = repository.findByDescription("Teaspoon");

        assertEquals("Teaspoon", op.get().getDescription());
    }

    @Test
    public void findByDescriptionCup() {

        var op = repository.findByDescription("Cup");

        assertEquals("Cup", op.get().getDescription());
    }

    @Test
    public void findByDescriptionPinch() {

        var op = repository.findByDescription("Pinch");

        assertEquals("Pinch", op.get().getDescription());
    }

    @Test
    public void findAll() {

        final var unitOfMeasures = repository.findAll();

        final List<UnitOfMeasure> list = new ArrayList<>();
        unitOfMeasures.forEach(list::add);

        assertEquals(10, list.size());
    }
}
