package br.com.edu.chuck.norris.jokes.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.edu.chuck.norris.jokes.service.JokeService;

/**
 * @author eduardo
 * @since 2022-06-15
 *
 */
@Controller
public class JokeController {

    private final JokeService service;

    public JokeController(final JokeService service) {
        super();
        this.service = service;
    }

    @GetMapping
    public String joke(final Model model) {

        final var joke = service.getJoke();

        model.addAttribute("joke", joke);

        return "index";
    }

}
