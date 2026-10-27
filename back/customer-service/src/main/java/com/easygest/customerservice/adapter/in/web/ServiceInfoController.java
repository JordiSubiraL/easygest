package com.easygest.customerservice.adapter.in.web;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class ServiceInfoController {

    @GetMapping("/")
    @PreAuthorize("hasRole('admin')")
    public Mono<String> getServiceInfo() {
        return Mono.just("Customer service is running. API endpoints are available under /api/v1.");
    }
}
