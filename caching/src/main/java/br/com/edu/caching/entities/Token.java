/* (C)2023 */
package br.com.edu.caching.entities;

import java.util.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@AllArgsConstructor
@ToString
public class Token {

    private static final int MAX_DURATION = 10 * 60;

    private String accessToken;

    private int randomId;

    private Date createdAt;

    public Token(String clientId) {
        createdAt = new Date();
        randomId = new Random().nextInt();
        accessToken = UUID.fromString(clientId).toString();
    }

    public long getExpiresIn() {
        long timeEnd = createdAt.getTime() + MAX_DURATION * 1000;
        return (timeEnd - System.currentTimeMillis()) / 1000;
    }

    public boolean isExpired() {
        return getExpiresIn() < 0;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return randomId == token.randomId &&
                Objects.equals(accessToken, token.accessToken) &&
                Objects.equals(createdAt, token.createdAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accessToken, randomId, createdAt);
    }
}
