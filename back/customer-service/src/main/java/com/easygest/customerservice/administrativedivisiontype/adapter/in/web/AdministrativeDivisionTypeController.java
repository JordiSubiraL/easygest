package com.easygest.customerservice.administrativedivisiontype.adapter.in.web;

import com.easygest.customerservice.administrativedivisiontype.application.port.in.GetAdministrativeDivisionTypeUseCase;
import com.easygest.customerservice.administrativedivisiontype.application.port.in.ManageAdministrativeDivisionTypeUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/administrative-division-types")
@RequiredArgsConstructor
public class AdministrativeDivisionTypeController {

    private final GetAdministrativeDivisionTypeUseCase getUseCase;
    private final ManageAdministrativeDivisionTypeUseCase manageUseCase;

    @GetMapping("/all")
    public Flux<AdministrativeDivisionTypeResponse> getAllAdministrativeDivisionTypes() {
        return getUseCase.getAllAdministrativeDivisionTypes().map(AdministrativeDivisionTypeResponse::from);
    }

    @GetMapping("/{id}")
    public Mono<AdministrativeDivisionTypeResponse> getAdministrativeDivisionTypeById(@PathVariable Long id) {
        return getUseCase.getAdministrativeDivisionTypeById(id).map(AdministrativeDivisionTypeResponse::from);
    }

    @GetMapping("/code/{code}")
    public Mono<AdministrativeDivisionTypeResponse> getAdministrativeDivisionTypeByCode(@PathVariable String code) {
        return getUseCase.getAdministrativeDivisionTypeByCode(code).map(AdministrativeDivisionTypeResponse::from);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<AdministrativeDivisionTypeResponse> createAdministrativeDivisionType(
            @Valid @RequestBody AdministrativeDivisionTypeRequest request) {
        return manageUseCase.createAdministrativeDivisionType(request.toRecord())
                .map(AdministrativeDivisionTypeResponse::from);
    }

    @PutMapping("/{id}")
    public Mono<AdministrativeDivisionTypeResponse> updateAdministrativeDivisionType(
            @PathVariable Long id, @Valid @RequestBody AdministrativeDivisionTypeRequest request) {
        return manageUseCase.updateAdministrativeDivisionType(id, request.toRecord(id))
                .map(AdministrativeDivisionTypeResponse::from);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteAdministrativeDivisionType(@PathVariable Long id) {
        return manageUseCase.deleteAdministrativeDivisionType(id);
    }
}
