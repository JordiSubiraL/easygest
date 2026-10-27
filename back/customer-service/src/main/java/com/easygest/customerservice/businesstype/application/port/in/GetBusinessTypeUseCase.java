package com.easygest.customerservice.businesstype.application.port.in;

import com.easygest.customerservice.businesstype.domain.model.BusinessTypeRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GetBusinessTypeUseCase {

    Flux<BusinessTypeRecord> getAllBusinessTypes();

    Mono<BusinessTypeRecord> getBusinessTypeById(Long id);

    Mono<BusinessTypeRecord> getBusinessTypeByCode(String code);
}
