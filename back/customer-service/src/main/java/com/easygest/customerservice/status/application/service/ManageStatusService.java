package com.easygest.customerservice.status.application.service;

import com.easygest.customerservice.status.application.port.in.ManageStatusUseCase;
import com.easygest.customerservice.status.application.port.out.StatusRepositoryPort;
import com.easygest.customerservice.common.NotFoundException;
import com.easygest.customerservice.status.domain.model.StatusRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ManageStatusService implements ManageStatusUseCase {

    private final StatusRepositoryPort repositoryPort;

    @Override
    public Mono<StatusRecord> createStatus(StatusRecord record) {
        return repositoryPort.createStatus(record);
    }

    @Override
    public Mono<StatusRecord> updateStatus(Long id, StatusRecord record) {
        return repositoryPort.getStatusById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Status not found with id " + id)))
                .flatMap(existing -> repositoryPort.updateStatus(id, record));
    }

    @Override
    public Mono<Void> deleteStatus(Long id) {
        return repositoryPort.getStatusById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Status not found with id " + id)))
                .flatMap(existing -> repositoryPort.deleteStatus(id));
    }
}
