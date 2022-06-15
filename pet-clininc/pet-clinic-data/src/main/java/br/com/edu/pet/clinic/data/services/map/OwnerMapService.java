package br.com.edu.pet.clinic.data.services.map;

import java.util.Set;

import org.springframework.stereotype.Service;

import br.com.edu.pet.clinic.data.model.Owner;
import br.com.edu.pet.clinic.data.services.OwnerService;

/**
 * @author eduardo
 * @since 2022-06-15
 *
 */
@Service
public class OwnerMapService extends AbstractMapService<Owner, Long> implements OwnerService {

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(final Long id) {
        return super.findById(id);
    }

    @Override
    public void deleteById(final Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(final Owner object) {
        super.delete(object);
    }

    @Override
    public Owner save(final Owner object) {
        return super.save(object);
    }

    @Override
    public Owner findByLastName(final String lastName) {
        return null;
    }

}
