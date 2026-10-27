package com.easygest.customerservice.permision.application.port.in;

import com.easygest.customerservice.permision.domain.model.PermisionRecord;
import reactor.core.publisher.Mono;

public interface ManagePermisionUseCase {

    Mono<PermisionRecord> createPermision(PermisionRecord record);

    Mono<PermisionRecord> updatePermision(Long id, PermisionRecord record);

    Mono<Void> deletePermision(Long id);
}
