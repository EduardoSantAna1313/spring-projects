package br.com.edu.pet.clininc.data.services;

import br.com.edu.pet.clininc.data.model.Owner;

import java.util.Set;

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();
}
