package com.easygest.customerservice.keycloack;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class KeycloackService {

    private final WebClient keycloak;

    public Flux<KeycloackUser> findByEmail(String email) {
        return keycloak.get()
                .uri(u-> u.path("/users")
                        .queryParam("email", email)
                        .queryParam("exact", true)
                        .build())
                .retrieve()
                .bodyToFlux(KeycloackUser.class);
    }

    public Mono<String> createUser(KeycloackUser user) {
        return keycloak.post()
                .uri("/users")
                .bodyValue(user)
                .retrieve()
                .toBodilessEntity()
                .map( resp -> {
                    String location = resp.getHeaders().getFirst("Location");
                    return location.substring(location.lastIndexOf("/") + 1);
                });
    }
}
