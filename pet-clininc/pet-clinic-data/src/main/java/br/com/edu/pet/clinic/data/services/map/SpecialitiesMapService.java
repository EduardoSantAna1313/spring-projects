/*
 * COPYRIGHT eduardo - ALL RIGHTS RESERVED.
 * 2022.
 */
package br.com.edu.pet.clinic.data.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.edu.pet.clinic.data.model.Speciality;
import br.com.edu.pet.clinic.data.services.SpecialityService;

/**
 * @author eduardo
 * @since 2022-06-17
 *
 */
@Service
public class SpecialitiesMapService extends AbstractMapService<Speciality, Long> implements SpecialityService {

    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public Speciality findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public Speciality save(final Speciality object) {
        return super.save(object);
    }

    @Override
    public void delete(final Speciality object) {
        super.delete(object);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

}
