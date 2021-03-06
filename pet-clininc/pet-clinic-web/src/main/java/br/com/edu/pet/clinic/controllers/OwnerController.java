package br.com.edu.pet.clinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.edu.pet.clinic.data.services.OwnerService;

/**
 * @author eduardo
 * @since 2022-06-15
 *
 */
@Controller
@RequestMapping
public class OwnerController {

    private final OwnerService ownerService;

    /**
     * Create a new instance of OwnerController
     *
     * @param ownerService
     */
    public OwnerController(final OwnerService ownerService) {
        super();
        this.ownerService = ownerService;
    }

    @RequestMapping({ "/owners","/owners.html", "/owners", "/owners/index", "/owners/index.html" })
    public String listOwners(final Model model) {

        model.addAttribute("owners", ownerService.findAll());

        return "owners/index";
    }

    @RequestMapping("/owners/find")
    public String findOwners() {
        return "notimplemented";
    }

}
