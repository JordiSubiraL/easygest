package com.easygest.customerservice.adapter.in.web.businesstype;

import com.easygest.customerservice.application.port.in.businessType.GetBusinessTypeUseCase;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/business-types")
@RequiredArgsConstructor
public class BusinessTypeController {

    private final GetBusinessTypeUseCase getBusinessTypeUseCase;

    @GetMapping("/all")
    private Flux<BusinessTypeResponse> getAllBusinessTypes() {
        return getBusinessTypeUseCase.getAllBusinessTypes().map(BusinessTypeResponse::from);
    }

    @GetMapping("/{code}")
    private Mono<BusinessTypeResponse> getBusinessTypeByCode(@PathVariable String code) {
        return getBusinessTypeUseCase.getBusinessTypeByCode(code).map(BusinessTypeResponse::from);
    }
}
