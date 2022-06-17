package br.com.edu.pet.clinic.data.model;

import java.util.Set;

/**
 * @author eduardo
 * @since 2022-06-15
 *
 */
public class Vet extends Person {

    /**
     * long - serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    private Set<Speciality> specialities;

    /**
     * Create a new instance of Vet
     *
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
