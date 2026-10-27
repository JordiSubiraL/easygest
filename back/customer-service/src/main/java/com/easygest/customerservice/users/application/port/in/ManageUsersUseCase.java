package com.easygest.customerservice.users.application.port.in;

import com.easygest.customerservice.users.domain.model.UsersRecord;
import reactor.core.publisher.Mono;

public interface ManageUsersUseCase {

    Mono<UsersRecord> createUsers(UsersRecord record);

    Mono<UsersRecord> updateUsers(Long id, UsersRecord record);

    Mono<Void> deleteUsers(Long id);
}
