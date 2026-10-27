package com.easygest.customerservice.society.application.port.in;

import com.easygest.customerservice.society.domain.model.SocietyRecord;
import reactor.core.publisher.Mono;

public interface ManageSocietyUseCase {

    Mono<SocietyRecord> createSociety(SocietyRecord record);

    Mono<SocietyRecord> updateSociety(Long id, SocietyRecord record);

    Mono<Void> deleteSociety(Long id);
}
