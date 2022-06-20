/*
 * COPYRIGHT eduardo - ALL RIGHTS RESERVED.
 * 2022.
 */
package br.com.edu.pet.clinic.data.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author eduardo
 * @since 2022-06-17
 */
@Entity
@Table(name = "visits")
public class Visit extends BaseEntity {

    /**
     * long - serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "pet_id")
    private Pet pet;

    /**
     * Retrieve the value of date.
     *
     * @return the date
     */
    public LocalDate getDate() {
        return date;
    }

    /**
     * Set a new value to date.
     *
     * @param date the date to set
     */
    public void setDate(final LocalDate date) {
        this.date = date;
    }

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

    /**
     * Retrieve the value of pet.
     *
     * @return the pet
     */
    public Pet getPet() {
        return pet;
    }

    /**
     * Set a new value to pet.
     *
     * @param pet the pet to set
     */
    public void setPet(final Pet pet) {
        this.pet = pet;
    }

}
