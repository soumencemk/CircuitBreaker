package com.soumen.circuitbreakerpoc;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.circuitbreaker.ReactiveCircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

/**
 * @author Soumen Karmakar
 * @Date 29/07/2021
 */

@Service
@Slf4j
@RequiredArgsConstructor
public class AlbumService {

    private final WebClient jsonPHWebClient = WebClient.builder().baseUrl("https://jsonplaceholder.typicode.com").build();
    private final ReactiveCircuitBreakerFactory reactiveCircuitBreakerFactory;

    public Flux<AlbumPojo> getAlbumList() {
        return jsonPHWebClient.get()
                .uri("/albums")
                .retrieve()
                .bodyToFlux(AlbumPojo.class)
                .transform(it -> reactiveCircuitBreakerFactory.create("cb").run(it, throwable -> Flux.just(new AlbumPojo())));
    }

}
