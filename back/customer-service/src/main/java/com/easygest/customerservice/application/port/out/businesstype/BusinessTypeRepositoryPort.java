package com.easygest.customerservice.application.port.out.businesstype;

import com.easygest.customerservice.domain.model.BusinessTypeRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BusinessTypeRepositoryPort{
    Flux<BusinessTypeRecord> getAllBusinessTypes();
    Mono<BusinessTypeRecord> getBusinessTypeByCode(String code);
}
