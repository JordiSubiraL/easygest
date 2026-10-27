package com.easygest.customerservice.users.application.service;

import com.easygest.customerservice.users.application.port.in.GetUsersUseCase;
import com.easygest.customerservice.users.application.port.out.UsersRepositoryPort;
import com.easygest.customerservice.users.domain.model.UsersRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetUsersService implements GetUsersUseCase {

    private final UsersRepositoryPort repositoryPort;

    @Override
    public Flux<UsersRecord> getAllUsers() {
        return repositoryPort.getAllUsers();
    }

    @Override
    public Mono<UsersRecord> getUsersById(Long id) {
        return repositoryPort.getUsersById(id);
    }
}
