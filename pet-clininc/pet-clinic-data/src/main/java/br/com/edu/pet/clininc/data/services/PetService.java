package br.com.edu.pet.clininc.data.services;

import br.com.edu.pet.clininc.data.model.Owner;
import br.com.edu.pet.clininc.data.model.Pet;

import java.util.Set;

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();
}



