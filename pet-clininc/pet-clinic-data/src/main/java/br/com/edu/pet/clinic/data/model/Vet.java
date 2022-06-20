package br.com.edu.pet.clinic.data.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author eduardo
 * @since 2022-06-15
 */
@Entity
@Table(name = "vets")
public class Vet extends Person {

    /**
     * long - serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities", joinColumns = @JoinColumn(name = "vet_id"), inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();

    /**
     * Create a new instance of Vet
     */
    public Vet() {
        super();
    }

    /**
     * Create a new instance of Vet
     *
     * @param firstName
     * @param lastName
     */
    public Vet(final String firstName, final String lastName) {
        super(firstName, lastName);
    }

    /**
     * Retrieve the value of specialities.
     *
     * @return the specialities
     */
    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    /**
     * Set a new value to specialities.
     *
     * @param specialities the specialities to set
     */
    public void setSpecialities(final Set<Speciality> specialities) {
        this.specialities = specialities;
    }

}
