package com.easygest.customerservice.users.application.port.out;

import com.easygest.customerservice.users.domain.model.UsersRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UsersRepositoryPort {

    Flux<UsersRecord> getAllUsers();

    Mono<UsersRecord> getUsersById(Long id);

    Mono<UsersRecord> findByUsername(String username);

    Mono<UsersRecord> findByEmail(String email);

    Mono<UsersRecord> createUsers(UsersRecord record);

    Mono<UsersRecord> updateUsers(Long id, UsersRecord record);

    Mono<Void> deleteUsers(Long id);
}
