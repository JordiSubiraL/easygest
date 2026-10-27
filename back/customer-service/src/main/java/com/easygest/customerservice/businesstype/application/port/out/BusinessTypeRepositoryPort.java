package com.easygest.customerservice.businesstype.application.port.out;

import com.easygest.customerservice.businesstype.domain.model.BusinessTypeRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface BusinessTypeRepositoryPort {
    Flux<BusinessTypeRecord> getAllBusinessTypes();

    Mono<BusinessTypeRecord> getBusinessTypeById(Long id);

    Mono<BusinessTypeRecord> getBusinessTypeByCode(String code);

    Mono<BusinessTypeRecord> createBusinessType(BusinessTypeRecord record);

    Mono<BusinessTypeRecord> updateBusinessType(Long id, BusinessTypeRecord record);

    Mono<Void> deleteBusinessType(Long id);
}
