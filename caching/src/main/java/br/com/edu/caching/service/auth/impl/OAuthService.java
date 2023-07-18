/* (C)2023 */
package br.com.edu.caching.service.auth.impl;

import br.com.edu.caching.entities.Token;
import br.com.edu.caching.service.auth.AuthenticationService;
import com.github.benmanes.caffeine.cache.Cache;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OAuthService implements AuthenticationService {

    @Autowired
    private Cache<String, Token> cache;
    @Override
    public Token getToken(String clientId) {
        return cache.get(clientId, (c) -> generateToken(c));
    }

    private Token generateToken(String clientId) {
        return new Token(clientId);
    }
}
