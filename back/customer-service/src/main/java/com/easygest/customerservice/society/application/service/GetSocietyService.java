package com.easygest.customerservice.society.application.service;

import com.easygest.customerservice.society.application.port.in.GetSocietyUseCase;
import com.easygest.customerservice.society.application.port.out.SocietyRepositoryPort;
import com.easygest.customerservice.society.domain.model.SocietyRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class GetSocietyService implements GetSocietyUseCase {

    private final SocietyRepositoryPort repositoryPort;

    @Override
    public Flux<SocietyRecord> getAllSocieties() {
        return repositoryPort.getAllSocieties();
    }

    @Override
    public Mono<SocietyRecord> getSocietyById(Long id) {
        return repositoryPort.getSocietyById(id);
    }

    @Override
    public Mono<SocietyRecord> getSocietyByPublicId(UUID publicId) {
        return repositoryPort.getSocietyByPublicId(publicId);
    }
}
