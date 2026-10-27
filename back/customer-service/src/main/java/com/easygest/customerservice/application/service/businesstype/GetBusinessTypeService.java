package com.easygest.customerservice.application.service.businessType;

import com.easygest.customerservice.application.port.in.businessType.GetBusinessTypeUseCase;
import com.easygest.customerservice.application.port.out.businesstype.BusinessTypeRepositoryPort;
import com.easygest.customerservice.domain.model.BusinessTypeRecord;
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
    public Mono<BusinessTypeRecord> getBusinessTypeByCode(String code) {
        return businessTypeRepositoryPort.getBusinessTypeByCode(code);
    }
}
