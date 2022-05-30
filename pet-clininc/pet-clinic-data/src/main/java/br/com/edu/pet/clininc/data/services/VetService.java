package br.com.edu.pet.clininc.data.services;

import br.com.edu.pet.clininc.data.model.Owner;
import br.com.edu.pet.clininc.data.model.Pet;
import br.com.edu.pet.clininc.data.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();
}
