package com.easygest.customerservice.status.application.port.in;

import com.easygest.customerservice.status.domain.model.StatusRecord;
import reactor.core.publisher.Mono;

public interface ManageStatusUseCase {

    Mono<StatusRecord> createStatus(StatusRecord record);

    Mono<StatusRecord> updateStatus(Long id, StatusRecord record);

    Mono<Void> deleteStatus(Long id);
}
