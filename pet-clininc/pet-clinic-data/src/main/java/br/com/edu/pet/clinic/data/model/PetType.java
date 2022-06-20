package br.com.edu.pet.clinic.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author eduardo
 * @since 2022-06-15
 */
@Entity
@Table(name = "types")
public class PetType extends BaseEntity {

    /**
     * long - serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "name")
    private String name;

    /**
     * Retrieve the value of name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Set a new value to name.
     *
     * @param name the name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

}
