package br.com.edu.dependency.injection.controllers;

import org.springframework.stereotype.Controller;

import com.springframework.pets.PetService;

@Controller
public class PetController {

	private final PetService petService;

	public PetController(final PetService petService) {
		this.petService = petService;
	}

	public String whichIsTheBest() {
		return petService.getPetType();
	}
}
