package br.com.edu.pet.clinic.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author eduardo
 * @since 2022-06-15
 *
 */
@Controller
public class IndexController {

    @RequestMapping({ "", "/", "index", "index.html" })
    public String index() {
        return "index";
    }
}
