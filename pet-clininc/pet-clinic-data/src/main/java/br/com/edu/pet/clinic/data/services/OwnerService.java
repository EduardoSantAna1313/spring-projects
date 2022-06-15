package br.com.edu.pet.clinic.data.services;

import br.com.edu.pet.clinic.data.model.Owner;

public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
