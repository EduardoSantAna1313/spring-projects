/* (C)2023 */
package br.com.edu.caching.service.auth;

import br.com.edu.caching.entities.Token;

public interface AuthenticationService {

    public Token getToken(String clientId);

}
