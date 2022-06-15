package br.com.edu.pet.clinic.data.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import br.com.edu.pet.clinic.data.model.BaseEntity;

/**
 * @author eduardo
 * @since 2022-06-15
 *
 * @param <T>
 * @param <ID>
 */
public abstract class AbstractMapService<T extends BaseEntity, ID extends Long> {

    /**
     * Map<ID,T> - map.
     */
    protected Map<Long, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(final ID id) {
        return map.get(id);
    }

    T save(final T object) {

        if (object != null) {
            if (object.getId() == null) {
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        } else {
            throw new NullPointerException();
        }

        return object;
    }

    void deleteById(final ID id) {
        map.remove(id);
    }

    void delete(final T object) {
        map.entrySet().removeIf(e -> e.getValue().equals(object));
    }

    private Long getNextId() {
        return (long) map.size() + 1;
    }

}
