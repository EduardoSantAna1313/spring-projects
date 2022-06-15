package br.com.edu.pet.clininc.data.services.map;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author eduardo
 * @since 2022-06-15
 *
 * @param <T>
 * @param <ID>
 */
public abstract class AbstractMapService<T, ID> {

    /**
     * Map<ID,T> - map.
     */
    protected Map<ID, T> map = new HashMap<>();

    Set<T> findAll() {
        return new HashSet<>(map.values());
    }

    T findById(final ID id) {
        return map.get(id);
    }

    T save(final ID id, final T object) {
        map.put(id, object);
        return object;
    }

    void deleteById(final ID id) {
        map.remove(id);
    }

    void delete(final T object) {
        map.entrySet().removeIf(e -> e.getValue().equals(object));
    }

}
