package br.com.pet.clinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author eduardo
 * @since 2022-06-15
 *
 */
@Controller
@RequestMapping("/owners")
public class OwnerController {

    @RequestMapping({ "", "/", "/index", "/index.html" })
    public String listOwners() {
        return "owners/index";
    }

}
