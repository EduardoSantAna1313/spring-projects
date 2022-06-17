/*
 * COPYRIGHT eduardo - ALL RIGHTS RESERVED.
 * 2022.
 */
package br.com.edu.pet.clinic.data.model;

/**
 * @author eduardo
 * @since 2022-06-17
 *
 */
public class Speciality extends BaseEntity {

    /**
     * long - serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    private String description;

    /**
     * Retrieve the value of description.
     *
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set a new value to description.
     *
     * @param description the description to set
     */
    public void setDescription(final String description) {
        this.description = description;
    }

}
