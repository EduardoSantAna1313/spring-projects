package br.com.edu.pet.clinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.edu.pet.clinic.data.services.VetService;

/**
 * @author eduardo
 * @since 2022-06-15
 *
 */
@Controller
public class VetController {

    private final VetService vetService;

    /**
     * Create a new instance of VetController
     *
     * @param vetService
     */
    public VetController(final VetService vetService) {
        super();
        this.vetService = vetService;
    }

    @RequestMapping({ "/vets", "/vets.html", "/vets/index", "/vets/index.html" })
    public String listVets(final Model model) {

        model.addAttribute("vets", vetService.findAll());

        return "vets/index";
    }
}
