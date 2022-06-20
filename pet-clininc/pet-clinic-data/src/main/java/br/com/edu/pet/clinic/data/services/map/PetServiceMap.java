package br.com.edu.pet.clinic.data.services.map;

import br.com.edu.pet.clinic.data.model.Pet;
import br.com.edu.pet.clinic.data.services.PetService;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author eduardo
 * @since 2022-06-15
 */
@Service
public class PetServiceMap extends AbstractMapService<Pet, Long> implements PetService {

    @Override
    public Set<Pet> findAll() {
        return super.findAll();
    }

    @Override
    public Pet findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final Pet object) {
        super.delete(object);
    }

    @Override
    public Pet save(final Pet object) {
        return super.save(object);
    }

}
