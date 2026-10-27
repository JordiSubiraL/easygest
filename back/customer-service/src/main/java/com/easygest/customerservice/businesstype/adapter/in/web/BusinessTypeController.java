package com.easygest.customerservice.businesstype.adapter.in.web;

import com.easygest.customerservice.businesstype.application.port.in.GetBusinessTypeUseCase;
import com.easygest.customerservice.businesstype.application.port.in.ManageBusinessTypeUseCase;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/business-types")
@RequiredArgsConstructor
public class BusinessTypeController {

    private final GetBusinessTypeUseCase getUseCase;
    private final ManageBusinessTypeUseCase manageUseCase;

    @GetMapping("/all")
    public Flux<BusinessTypeResponse> getAllBusinessTypes() {
        return getUseCase.getAllBusinessTypes().map(BusinessTypeResponse::from);
    }

    @GetMapping("/{id}")
    public Mono<BusinessTypeResponse> getBusinessTypeById(@PathVariable Long id) {
        return getUseCase.getBusinessTypeById(id).map(BusinessTypeResponse::from);
    }

    @GetMapping("/code/{code}")
    public Mono<BusinessTypeResponse> getBusinessTypeByCode(@PathVariable String code) {
        return getUseCase.getBusinessTypeByCode(code).map(BusinessTypeResponse::from);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Mono<BusinessTypeResponse> createBusinessType(@Valid @RequestBody BusinessTypeRequest request) {
        return manageUseCase.createBusinessType(request.toRecord()).map(BusinessTypeResponse::from);
    }

    @PutMapping("/{id}")
    public Mono<BusinessTypeResponse> updateBusinessType(
            @PathVariable Long id, @Valid @RequestBody BusinessTypeRequest request) {
        return manageUseCase.updateBusinessType(id, request.toRecord(id)).map(BusinessTypeResponse::from);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> deleteBusinessType(@PathVariable Long id) {
        return manageUseCase.deleteBusinessType(id);
    }
}
