package com.easygest.customerservice.society.application.port.out;

import com.easygest.customerservice.society.domain.model.SocietyRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

public interface SocietyRepositoryPort {

    Flux<SocietyRecord> getAllSocieties();

    Mono<SocietyRecord> getSocietyById(Long id);

    Mono<SocietyRecord> getSocietyByPublicId(UUID publicId);

    Mono<SocietyRecord> createSociety(SocietyRecord record);

    Mono<SocietyRecord> updateSociety(Long id, SocietyRecord record);

    Mono<Void> deleteSociety(Long id);
}
