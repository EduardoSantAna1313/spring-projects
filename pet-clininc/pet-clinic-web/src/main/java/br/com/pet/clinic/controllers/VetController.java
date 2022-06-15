package br.com.pet.clinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author eduardo
 * @since 2022-06-15
 *
 */
@Controller
public class VetController {

    @RequestMapping({ "/vets", "/vets/index", "/vets/index.html" })
    public String listVets() {
        return "vets/index";
    }
}
