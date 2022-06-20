package br.com.edu.pet.clinic.data.model;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author eduardo
 * @since 2022-06-15
 */
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    /**
     * long - serialVersionUID.
     */
    private static final long serialVersionUID = 1L;

    @Column(name = "name")
    private String name;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "birth_date")
    private LocalDate birthDate;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private final Set<Visit> visits = new HashSet<>();

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

    /**
     * Retrieve the value of visits.
     *
     * @return the visits
     */
    public Set<Visit> getVisits() {
        return visits;
    }

}
