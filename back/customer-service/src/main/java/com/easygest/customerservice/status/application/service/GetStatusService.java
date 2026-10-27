package com.easygest.customerservice.status.application.service;

import com.easygest.customerservice.status.application.port.in.GetStatusUseCase;
import com.easygest.customerservice.status.application.port.out.StatusRepositoryPort;
import com.easygest.customerservice.status.domain.model.StatusRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetStatusService implements GetStatusUseCase {

    private final StatusRepositoryPort repositoryPort;

    @Override
    public Flux<StatusRecord> getAllStatuses() {
        return repositoryPort.getAllStatuses();
    }

    @Override
    public Mono<StatusRecord> getStatusById(Long id) {
        return repositoryPort.getStatusById(id);
    }

    @Override
    public Mono<StatusRecord> getStatusByCode(String code) {
        return repositoryPort.getStatusByCode(code);
    }
}
