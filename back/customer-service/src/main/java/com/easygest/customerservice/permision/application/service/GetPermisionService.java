package com.easygest.customerservice.permision.application.service;

import com.easygest.customerservice.permision.application.port.in.GetPermisionUseCase;
import com.easygest.customerservice.permision.application.port.out.PermisionRepositoryPort;
import com.easygest.customerservice.permision.domain.model.PermisionRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetPermisionService implements GetPermisionUseCase {

    private final PermisionRepositoryPort repositoryPort;

    @Override
    public Flux<PermisionRecord> getAllPermisions() {
        return repositoryPort.getAllPermisions();
    }

    @Override
    public Mono<PermisionRecord> getPermisionById(Long id) {
        return repositoryPort.getPermisionById(id);
    }

    @Override
    public Mono<PermisionRecord> getPermisionByCode(String code) {
        return repositoryPort.getPermisionByCode(code);
    }
}
