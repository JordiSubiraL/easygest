package com.easygest.customerservice.permision.application.port.in;

import com.easygest.customerservice.permision.domain.model.PermisionRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GetPermisionUseCase {

    Flux<PermisionRecord> getAllPermisions();

    Mono<PermisionRecord> getPermisionById(Long id);

    Mono<PermisionRecord> getPermisionByCode(String code);
}
