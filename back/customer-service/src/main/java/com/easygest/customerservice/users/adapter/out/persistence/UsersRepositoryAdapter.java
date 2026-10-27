package com.easygest.customerservice.users.adapter.out.persistence;

import com.easygest.customerservice.users.application.port.out.UsersRepositoryPort;
import com.easygest.customerservice.users.domain.model.UsersRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class UsersRepositoryAdapter implements UsersRepositoryPort {

    private final UsersR2dbcRepository repository;
    private final UsersMapper mapper;

    @Override
    public Flux<UsersRecord> getAllUsers() {
        return repository.findAll().map(mapper::toDomain);
    }

    @Override
    public Mono<UsersRecord> getUsersById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Mono<UsersRecord> findByUsername(String username) {
        return repository.findByUsername(username).map(mapper::toDomain);
    }

    @Override
    public Mono<UsersRecord> findByEmail(String email) {
        return repository.findByEmail(email).map(mapper::toDomain);
    }

    @Override
    public Mono<UsersRecord> createUsers(UsersRecord record) {
        return repository.save(mapper.toEntity(record)).map(mapper::toDomain);
    }

    @Override
    public Mono<UsersRecord> updateUsers(Long id, UsersRecord record) {
        return repository.findById(id)
                .flatMap(existing -> {
                    UsersEntity entity = mapper.toEntity(record);
                    entity.setId(id);
                    entity.copyAuditingFrom(existing);
                    return repository.save(entity);
                })
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteUsers(Long id) {
        return repository.deleteById(id);
    }
}
