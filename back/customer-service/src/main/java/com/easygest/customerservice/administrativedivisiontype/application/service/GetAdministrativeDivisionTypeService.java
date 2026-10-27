package com.easygest.customerservice.administrativedivisiontype.application.service;

import com.easygest.customerservice.administrativedivisiontype.application.port.in.GetAdministrativeDivisionTypeUseCase;
import com.easygest.customerservice.administrativedivisiontype.application.port.out.AdministrativeDivisionTypeRepositoryPort;
import com.easygest.customerservice.administrativedivisiontype.domain.model.AdministrativeDivisionTypeRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetAdministrativeDivisionTypeService implements GetAdministrativeDivisionTypeUseCase {

    private final AdministrativeDivisionTypeRepositoryPort repositoryPort;

    @Override
    public Flux<AdministrativeDivisionTypeRecord> getAllAdministrativeDivisionTypes() {
        return repositoryPort.getAllAdministrativeDivisionTypes();
    }

    @Override
    public Mono<AdministrativeDivisionTypeRecord> getAdministrativeDivisionTypeById(Long id) {
        return repositoryPort.getAdministrativeDivisionTypeById(id);
    }

    @Override
    public Mono<AdministrativeDivisionTypeRecord> getAdministrativeDivisionTypeByCode(String code) {
        return repositoryPort.getAdministrativeDivisionTypeByCode(code);
    }
}
