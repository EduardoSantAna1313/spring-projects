package br.com.edu.caching;

import br.com.edu.caching.entities.Token;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class CacheSimpleTest {

    private static final int MAX_SIZE = 2;

    private  Cache<String, Token> cache;

    @BeforeEach
    public void setUp() {
        cache = Caffeine.newBuilder()
                .expireAfterWrite(300,TimeUnit.SECONDS)
                .maximumSize(MAX_SIZE)
                .build();
    }

    @Test
    public void shouldNotCreateMoreThanMax() throws InterruptedException {
        for (int i =0; i < MAX_SIZE*10; i++)
        {
            final var uuid = UUID.randomUUID().toString();
            cache.get(uuid, c-> new Token(uuid));
        }

        Thread.sleep(1000);
        assertEquals(2, cache.estimatedSize());
    }

    @Test
    public  void shouldCreateOnlyOneToken () {

        final var uuid = UUID.randomUUID().toString();

        for (int i =0; i < 20; i++)
        {
            cache.get(uuid, c-> new Token(uuid));
        }

        assertEquals(1, cache.estimatedSize());
        assertNotNull(cache.getIfPresent(uuid));
        assertEquals(UUID.fromString(uuid).toString(), cache.getIfPresent(uuid).getAccessToken());
    }

    @Test
    public  void shouldCreateOnlyOneTokenWithThreads () {
        final ThreadPoolExecutor service = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);

        final var uuid = UUID.randomUUID().toString();

        AtomicInteger createdTokens = new AtomicInteger(0);
        for (int i =0; i < 20; i++)
        {
            service.submit(() -> {
                cache.get(uuid, c-> {
                    createdTokens.incrementAndGet();
                    return new Token(uuid);
                });
            });
        }
        service.shutdown();

        while(!service.isTerminated()) {
        }

        assertEquals(1, cache.estimatedSize());
        assertEquals(1, createdTokens.get());
        assertNotNull(cache.getIfPresent(uuid));
        assertEquals(UUID.fromString(uuid).toString(), cache.getIfPresent(uuid).getAccessToken());
    }

}
