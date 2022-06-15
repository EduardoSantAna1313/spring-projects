package br.com.edu.pet.clininc.data.model;

import java.io.Serializable;

/**
 * @author eduardo
 * @since 2022-06-15
 *
 */
public class BaseEntity implements Serializable {

    /**
     * long - serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    private Long id;

    /**
     * Retrieve the value of id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Set a new value to id.
     *
     * @param id the id to set
     */
    public void setId(final Long id) {
        this.id = id;
    }

}
