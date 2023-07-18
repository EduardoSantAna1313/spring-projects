/* (C)2023 */
package br.com.edu.caching.controller;

import br.com.edu.caching.entities.Token;
import br.com.edu.caching.service.auth.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class TokenController {

    @Autowired
    private AuthenticationService service;

    @PostMapping(value = "/token",
            consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Token getToken(@RequestParam("client_id") String clientId) {
        return service.getToken(clientId);
    }
}
