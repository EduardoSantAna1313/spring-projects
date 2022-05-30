package br.com.edu.pet.clininc.data.services;

import br.com.edu.pet.clininc.data.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}