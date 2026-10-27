package com.easygest.customerservice.society.application.port.in;

import com.easygest.customerservice.society.domain.model.SocietyRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface GetSocietyUseCase {

    Flux<SocietyRecord> getAllSocieties();

    Mono<SocietyRecord> getSocietyById(Long id);

    Mono<SocietyRecord> getSocietyByPublicId(UUID publicId);
}
