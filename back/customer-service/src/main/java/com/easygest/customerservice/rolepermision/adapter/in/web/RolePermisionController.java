package com.easygest.customerservice.rolepermision.adapter.in.web;

import com.easygest.customerservice.rolepermision.application.port.in.GetRolePermisionUseCase;
import com.easygest.customerservice.rolepermision.application.port.in.ManageRolePermisionUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/role-permisions")
@RequiredArgsConstructor
public class RolePermisionController {

    private final GetRolePermisionUseCase getRolePermisionUseCase;
    private final ManageRolePermisionUseCase manageRolePermisionUseCase;

    @GetMapping("/all")
    public Flux<RolePermisionResponse> getAllRolePermisions() {
        return getRolePermisionUseCase.getAllRolePermisions().map(RolePermisionResponse::from);
    }

    @GetMapping("/{id}")
    public Mono<RolePermisionResponse> getRolePermisionById(@PathVariable Long id) {
        return getRolePermisionUseCase.getRolePermisionById(id).map(RolePermisionResponse::from);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<RolePermisionResponse> createRolePermision(@Valid @RequestBody RolePermisionRequest request) {
        return manageRolePermisionUseCase.createRolePermision(request.toRecord()).map(RolePermisionResponse::from);
    }

    @PutMapping("/{id}")
    public Mono<RolePermisionResponse> updateRolePermision(@PathVariable Long id, @Valid @RequestBody RolePermisionRequest request) {
        return manageRolePermisionUseCase.updateRolePermision(id, request.toRecord(id)).map(RolePermisionResponse::from);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteRolePermision(@PathVariable Long id) {
        return manageRolePermisionUseCase.deleteRolePermision(id);
    }
}
