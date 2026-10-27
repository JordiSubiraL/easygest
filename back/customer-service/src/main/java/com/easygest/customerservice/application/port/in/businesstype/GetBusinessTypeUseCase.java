package com.easygest.customerservice.application.port.in.businessType;

import com.easygest.customerservice.adapter.in.web.businesstype.BusinessTypeResponse;
import com.easygest.customerservice.domain.model.BusinessTypeRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GetBusinessTypeUseCase {

    Flux<BusinessTypeRecord> getAllBusinessTypes();
    Mono<BusinessTypeRecord> getBusinessTypeByCode(String code);
}
