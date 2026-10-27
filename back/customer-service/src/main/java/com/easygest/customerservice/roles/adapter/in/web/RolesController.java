package com.easygest.customerservice.roles.adapter.in.web;

import com.easygest.customerservice.roles.application.port.in.GetRolesUseCase;
import com.easygest.customerservice.roles.application.port.in.ManageRolesUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RolesController {

    private final GetRolesUseCase getUseCase;
    private final ManageRolesUseCase manageUseCase;

    @GetMapping("/all")
    public Flux<RolesResponse> getAllRoles() {
        return getUseCase.getAllRoles().map(RolesResponse::from);
    }

    @GetMapping("/{id}")
    public Mono<RolesResponse> getRolesById(@PathVariable Long id) {
        return getUseCase.getRolesById(id).map(RolesResponse::from);
    }

    @GetMapping("/code/{code}")
    public Mono<RolesResponse> getRolesByCode(@PathVariable String code) {
        return getUseCase.getRolesByCode(code).map(RolesResponse::from);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<RolesResponse> createRoles(@Valid @RequestBody RolesRequest request) {
        return manageUseCase.createRoles(request.toRecord()).map(RolesResponse::from);
    }

    @PutMapping("/{id}")
    public Mono<RolesResponse> updateRoles(@PathVariable Long id, @Valid @RequestBody RolesRequest request) {
        return manageUseCase.updateRoles(id, request.toRecord(id)).map(RolesResponse::from);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteRoles(@PathVariable Long id) {
        return manageUseCase.deleteRoles(id);
    }
}
