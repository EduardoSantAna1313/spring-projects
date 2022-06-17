/*
 * COPYRIGHT eduardo - ALL RIGHTS RESERVED.
 * 2022.
 */
package br.com.edu.pet.clinic.data.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.edu.pet.clinic.data.model.PetType;
import br.com.edu.pet.clinic.data.services.PetTypeService;

/**
 * @author eduardo
 * @since 2022-06-17
 *
 */
@Service
public class PetTypeMapService extends AbstractMapService<PetType, Long> implements PetTypeService {

    @Override
    public Set<PetType> findAll() {
        return super.findAll();
    }

    @Override
    public PetType findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final PetType object) {
        super.delete(object);
    }

    @Override
    public PetType save(final PetType object) {
        return super.save(object);
    }
}