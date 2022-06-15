package br.com.edu.pet.clininc.data.model;

import java.time.LocalDate;

/**
 * @author eduardo
 * @since 2022-06-15
 *
 */
public class Pet extends BaseEntity {

    /**
     * long - serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    private PetType petType;

    private Owner owner;

    private LocalDate birthDate;

    /**
     * Retrieve the value of petType.
     *
     * @return the petType
     */
    public PetType getPetType() {
        return petType;
    }

    /**
     * Set a new value to petType.
     *
     * @param petType the petType to set
     */
    public void setPetType(final PetType petType) {
        this.petType = petType;
    }

    /**
     * Retrieve the value of owner.
     *
     * @return the owner
     */
    public Owner getOwner() {
        return owner;
    }

    /**
     * Set a new value to owner.
     *
     * @param owner the owner to set
     */
    public void setOwner(final Owner owner) {
        this.owner = owner;
    }

    /**
     * Retrieve the value of birthDate.
     *
     * @return the birthDate
     */
    public LocalDate getBirthDate() {
        return birthDate;
    }

    /**
     * Set a new value to birthDate.
     *
     * @param birthDate the birthDate to set
     */
    public void setBirthDate(final LocalDate birthDate) {
        this.birthDate = birthDate;
    }

}
