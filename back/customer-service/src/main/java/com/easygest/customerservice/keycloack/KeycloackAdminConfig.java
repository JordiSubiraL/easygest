package com.easygest.customerservice.keycloack;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientManager;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientProviderBuilder;
import org.springframework.security.oauth2.client.ReactiveOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.registration.ReactiveClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.reactive.function.client.ServerOAuth2AuthorizedClientExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class KeycloackAdminConfig {

    @Bean
    ReactiveOAuth2AuthorizedClientManager keycloakAuthorizedClientManager(
      ReactiveClientRegistrationRepository repository,
      ReactiveOAuth2AuthorizedClientService authorizedClientManager
    ){
        var manager = new AuthorizedClientServiceReactiveOAuth2AuthorizedClientManager(repository,authorizedClientManager);
        manager.setAuthorizedClientProvider(ReactiveOAuth2AuthorizedClientProviderBuilder.builder()
                .clientCredentials()
                .build());
        return manager;

    }

    @Bean
    WebClient keycloackAdminWebClient(ReactiveOAuth2AuthorizedClientManager manager){
        var oauth = new ServerOAuth2AuthorizedClientExchangeFilterFunction(manager);
        oauth.setDefaultClientRegistrationId("keycloack-admin");

        return WebClient.builder()
                .baseUrl("http://localhost:8080/admin/realms/Dev")
                .filter(oauth)
                .build();
    }

}
