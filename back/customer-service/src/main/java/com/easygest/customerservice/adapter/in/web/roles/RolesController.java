package com.easygest.customerservice.adapter.in.web.roles;

import com.easygest.customerservice.application.port.in.roles.GetRolesUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RolesController {

    private final GetRolesUseCase getRolesUseCase;

    @GetMapping("/all")
    public Flux<RolesResponse> getAllRoles() {
        return getRolesUseCase.getAllRoles().map(RolesResponse::from);
    }
}
