package br.com.edu.pet.clinic.data.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.edu.pet.clinic.data.model.Vet;
import br.com.edu.pet.clinic.data.services.VetService;

/**
 * @author eduardo
 * @since 2022-06-15
 *
 */
@Service
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {

    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public Vet findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final Vet object) {
        super.delete(object);
    }

    @Override
    public Vet save(final Vet object) {
        return super.save(object.getId(), object);
    }

}
