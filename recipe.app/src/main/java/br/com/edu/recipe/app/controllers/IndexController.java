/*
 * COPYRIGHT eduardo - ALL RIGHTS RESERVED.
 * 2022.
 */
package br.com.edu.recipe.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author eduardo
 * @since 2022-06-17
 *
 */
@Controller
public class IndexController {

    @RequestMapping({ "/", "/index", "/index.html" })
    public String index() {
        return "index";
    }

}
