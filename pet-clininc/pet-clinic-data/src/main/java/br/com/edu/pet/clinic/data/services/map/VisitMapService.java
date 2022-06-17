/*
 * COPYRIGHT eduardo - ALL RIGHTS RESERVED.
 * 2022.
 */
package br.com.edu.pet.clinic.data.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.edu.pet.clinic.data.model.Visit;
import br.com.edu.pet.clinic.data.services.VisitService;

/**
 * @author eduardo
 * @since 2022-06-17
 *
 */
@Service
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {

    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public Visit findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final Visit object) {
        super.delete(object);
    }

    @Override
    public Visit save(final Visit object) {
        return super.save(object);
    }
}
