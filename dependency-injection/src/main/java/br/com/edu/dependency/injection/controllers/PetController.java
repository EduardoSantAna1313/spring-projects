package br.com.edu.dependency.injection.controllers;

import br.com.edu.dependency.injection.service.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class PetController {

    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    public String whichIsTheBest() {
        return petService.getPetType();
    }
}
