package com.easygest.customerservice.administrativedivision.application.service;

import com.easygest.customerservice.administrativedivision.application.port.in.GetAdministrativeDivisionUseCase;
import com.easygest.customerservice.administrativedivision.application.port.out.AdministrativeDivisionRepositoryPort;
import com.easygest.customerservice.administrativedivision.domain.model.AdministrativeDivisionRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetAdministrativeDivisionService implements GetAdministrativeDivisionUseCase {

    private final AdministrativeDivisionRepositoryPort repositoryPort;

    @Override
    public Flux<AdministrativeDivisionRecord> getAllAdministrativeDivision() {
        return repositoryPort.getAllAdministrativeDivision();
    }

    @Override
    public Mono<AdministrativeDivisionRecord> getAdministrativeDivisionById(Long id) {
        return repositoryPort.getAdministrativeDivisionById(id);
    }

    @Override
    public Mono<AdministrativeDivisionRecord> getAdministrativeDivisionByCode(String code) {
        return repositoryPort.getAdministrativeDivisionByCode(code);
    }
}
