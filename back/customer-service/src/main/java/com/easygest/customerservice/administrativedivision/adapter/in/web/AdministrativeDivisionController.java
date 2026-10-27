package com.easygest.customerservice.administrativedivision.adapter.in.web;

import com.easygest.customerservice.administrativedivision.application.port.in.GetAdministrativeDivisionUseCase;
import com.easygest.customerservice.administrativedivision.application.port.in.ManageAdministrativeDivisionUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/administrative-divisions")
@RequiredArgsConstructor
public class AdministrativeDivisionController {

    private final GetAdministrativeDivisionUseCase getUseCase;
    private final ManageAdministrativeDivisionUseCase manageUseCase;

    @GetMapping("/all")
    public Flux<AdministrativeDivisionResponse> getAllAdministrativeDivisions() {
        return getUseCase.getAllAdministrativeDivision().map(AdministrativeDivisionResponse::from);
    }

    @GetMapping("/{id}")
    public Mono<AdministrativeDivisionResponse> getAdministrativeDivisionById(@PathVariable Long id) {
        return getUseCase.getAdministrativeDivisionById(id).map(AdministrativeDivisionResponse::from);
    }

    @GetMapping("/code/{code}")
    public Mono<AdministrativeDivisionResponse> getAdministrativeDivisionByCode(@PathVariable String code) {
        return getUseCase.getAdministrativeDivisionByCode(code).map(AdministrativeDivisionResponse::from);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<AdministrativeDivisionResponse> createAdministrativeDivision(
            @Valid @RequestBody AdministrativeDivisionRequest request) {
        return manageUseCase.createAdministrativeDivision(request.toRecord())
                .map(AdministrativeDivisionResponse::from);
    }

    @PutMapping("/{id}")
    public Mono<AdministrativeDivisionResponse> updateAdministrativeDivision(
            @PathVariable Long id, @Valid @RequestBody AdministrativeDivisionRequest request) {
        return manageUseCase.updateAdministrativeDivision(id, request.toRecord(id))
                .map(AdministrativeDivisionResponse::from);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAdministrativeDivision(@PathVariable Long id) {
        return manageUseCase.deleteAdministrativeDivision(id);
    }
}
