package com.easygest.customerservice.users.application.service;

import com.easygest.customerservice.users.application.port.in.ManageUsersUseCase;
import com.easygest.customerservice.users.application.port.out.UsersRepositoryPort;
import com.easygest.customerservice.common.NotFoundException;
import com.easygest.customerservice.users.domain.model.UsersRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ManageUsersService implements ManageUsersUseCase {

    private final UsersRepositoryPort repositoryPort;

    @Override
    public Mono<UsersRecord> createUsers(UsersRecord record) {
        return repositoryPort.createUsers(record);
    }

    @Override
    public Mono<UsersRecord> updateUsers(Long id, UsersRecord record) {
        return repositoryPort.getUsersById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("User not found with id " + id)))
                .flatMap(existing -> repositoryPort.updateUsers(id, record));
    }

    @Override
    public Mono<Void> deleteUsers(Long id) {
        return repositoryPort.getUsersById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("User not found with id " + id)))
                .flatMap(existing -> repositoryPort.deleteUsers(id));
    }
}
