package com.easygest.customerservice.businesstype.application.service;

import com.easygest.customerservice.businesstype.application.port.in.GetBusinessTypeUseCase;
import com.easygest.customerservice.businesstype.application.port.out.BusinessTypeRepositoryPort;
import com.easygest.customerservice.businesstype.domain.model.BusinessTypeRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetBusinessTypeService implements GetBusinessTypeUseCase {

    private final BusinessTypeRepositoryPort businessTypeRepositoryPort;

    @Override
    public Flux<BusinessTypeRecord> getAllBusinessTypes() {
        return businessTypeRepositoryPort.getAllBusinessTypes();
    }

    @Override
    public Mono<BusinessTypeRecord> getBusinessTypeById(Long id) {
        return businessTypeRepositoryPort.getBusinessTypeById(id);
    }

    @Override
    public Mono<BusinessTypeRecord> getBusinessTypeByCode(String code) {
        return businessTypeRepositoryPort.getBusinessTypeByCode(code);
    }
}
