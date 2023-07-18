/* (C)2023 */
package br.com.edu.caching.config;

import br.com.edu.caching.entities.Token;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import java.util.concurrent.TimeUnit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CacheConfig {

    @Bean
    public Cache<String, Token> getCache() {
        return Caffeine.newBuilder()
                .expireAfterWrite(2, TimeUnit.SECONDS)
                .maximumSize(2)
                .build();
    }

}
