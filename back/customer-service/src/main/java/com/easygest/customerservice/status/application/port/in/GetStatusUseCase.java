package com.easygest.customerservice.status.application.port.in;

import com.easygest.customerservice.status.domain.model.StatusRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GetStatusUseCase {

    Flux<StatusRecord> getAllStatuses();

    Mono<StatusRecord> getStatusById(Long id);

    Mono<StatusRecord> getStatusByCode(String code);
}
