package com.easygest.customerservice.businesstype.application.port.in;

import com.easygest.customerservice.businesstype.domain.model.BusinessTypeRecord;
import reactor.core.publisher.Mono;

public interface ManageBusinessTypeUseCase {

    Mono<BusinessTypeRecord> createBusinessType(BusinessTypeRecord record);

    Mono<BusinessTypeRecord> updateBusinessType(Long id, BusinessTypeRecord record);

    Mono<Void> deleteBusinessType(Long id);
}
