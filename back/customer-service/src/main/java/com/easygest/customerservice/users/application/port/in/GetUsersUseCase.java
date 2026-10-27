package com.easygest.customerservice.users.application.port.in;

import com.easygest.customerservice.users.domain.model.UsersRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GetUsersUseCase {

    Flux<UsersRecord> getAllUsers();

    Mono<UsersRecord> getUsersById(Long id);
}
