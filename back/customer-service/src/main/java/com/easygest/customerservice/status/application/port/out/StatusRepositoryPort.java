package com.easygest.customerservice.status.application.port.out;

import com.easygest.customerservice.status.domain.model.StatusRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface StatusRepositoryPort {

    Flux<StatusRecord> getAllStatuses();

    Mono<StatusRecord> getStatusById(Long id);

    Mono<StatusRecord> getStatusByCode(String code);

    Mono<StatusRecord> createStatus(StatusRecord record);

    Mono<StatusRecord> updateStatus(Long id, StatusRecord record);

    Mono<Void> deleteStatus(Long id);
}
