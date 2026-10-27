package com.easygest.customerservice.permision.application.service;

import com.easygest.customerservice.permision.application.port.in.ManagePermisionUseCase;
import com.easygest.customerservice.permision.application.port.out.PermisionRepositoryPort;
import com.easygest.customerservice.common.NotFoundException;
import com.easygest.customerservice.permision.domain.model.PermisionRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ManagePermisionService implements ManagePermisionUseCase {

    private final PermisionRepositoryPort repositoryPort;

    @Override
    public Mono<PermisionRecord> createPermision(PermisionRecord record) {
        return repositoryPort.createPermision(record);
    }

    @Override
    public Mono<PermisionRecord> updatePermision(Long id, PermisionRecord record) {
        return repositoryPort.getPermisionById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Permision not found with id " + id)))
                .flatMap(existing -> repositoryPort.updatePermision(id, record));
    }

    @Override
    public Mono<Void> deletePermision(Long id) {
        return repositoryPort.getPermisionById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Permision not found with id " + id)))
                .flatMap(existing -> repositoryPort.deletePermision(id));
    }
}
