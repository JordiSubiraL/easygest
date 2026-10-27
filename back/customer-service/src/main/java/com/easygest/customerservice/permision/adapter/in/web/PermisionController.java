package com.easygest.customerservice.permision.adapter.in.web;

import com.easygest.customerservice.permision.application.port.in.GetPermisionUseCase;
import com.easygest.customerservice.permision.application.port.in.ManagePermisionUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/permisions")
@RequiredArgsConstructor
public class PermisionController {

    private final GetPermisionUseCase getPermisionUseCase;
    private final ManagePermisionUseCase managePermisionUseCase;

    @GetMapping("/all")
    public Flux<PermisionResponse> getAllPermisions() {
        return getPermisionUseCase.getAllPermisions().map(PermisionResponse::from);
    }

    @GetMapping("/{id}")
    public Mono<PermisionResponse> getPermisionById(@PathVariable Long id) {
        return getPermisionUseCase.getPermisionById(id).map(PermisionResponse::from);
    }

    @GetMapping("/code/{code}")
    public Mono<PermisionResponse> getPermisionByCode(@PathVariable String code) {
        return getPermisionUseCase.getPermisionByCode(code).map(PermisionResponse::from);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<PermisionResponse> createPermision(@Valid @RequestBody PermisionRequest request) {
        return managePermisionUseCase.createPermision(request.toRecord()).map(PermisionResponse::from);
    }

    @PutMapping("/{id}")
    public Mono<PermisionResponse> updatePermision(@PathVariable Long id, @Valid @RequestBody PermisionRequest request) {
        return managePermisionUseCase.updatePermision(id, request.toRecord(id)).map(PermisionResponse::from);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deletePermision(@PathVariable Long id) {
        return managePermisionUseCase.deletePermision(id);
    }
}
