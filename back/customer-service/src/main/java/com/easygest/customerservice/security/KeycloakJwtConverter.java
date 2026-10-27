package com.easygest.customerservice.security;

import org.springframework.core.convert.converter.Converter;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.oauth2.server.resource.authentication.ReactiveJwtAuthenticationConverterAdapter;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import java.util.*;

@Component
public class KeycloakJwtConverter{

    private final ReactiveJwtAuthenticationConverterAdapter delegate;

    public KeycloakJwtConverter(){

        var converter = new JwtAuthenticationConverter();
        converter.setJwtGrantedAuthoritiesConverter(this::extractAuthorities);
        this.delegate = new ReactiveJwtAuthenticationConverterAdapter(converter);
    }

    public Mono<AbstractAuthenticationToken> convert(Jwt jwt) {
        return delegate.convert(jwt);
    }

    private Collection<GrantedAuthority> extractAuthorities(Jwt jwt){
        Map<String, Object> realmAcces = jwt.getClaim("realm_access");

        if(realmAcces == null){
            return  Set.of();
        }

        Collection<String> roles = (Collection<String>) realmAcces.get("roles");

        if(roles == null){
            return Set.of();
        }

        return roles.stream()
                .map(role -> (GrantedAuthority) new SimpleGrantedAuthority("ROLE_".concat(role)))
                .toList();
    }
}
