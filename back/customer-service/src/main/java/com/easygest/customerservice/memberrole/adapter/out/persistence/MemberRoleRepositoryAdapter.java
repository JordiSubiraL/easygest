package com.easygest.customerservice.memberrole.adapter.out.persistence;

import com.easygest.customerservice.memberrole.application.port.out.MemberRoleRepositoryPort;
import com.easygest.customerservice.memberrole.domain.model.MemberRoleRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class MemberRoleRepositoryAdapter implements MemberRoleRepositoryPort {

    private final MemberRoleR2dbcRepository repository;
    private final MemberRoleMapper mapper;

    @Override
    public Flux<MemberRoleRecord> getAllMemberRoles() {
        return repository.findAll().map(mapper::toDomain);
    }

    @Override
    public Mono<MemberRoleRecord> getMemberRoleById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Mono<MemberRoleRecord> createMemberRole(MemberRoleRecord record) {
        return repository.save(mapper.toEntity(record)).map(mapper::toDomain);
    }

    @Override
    public Mono<MemberRoleRecord> updateMemberRole(Long id, MemberRoleRecord record) {
        return repository.findById(id)
                .flatMap(existing -> {
                    MemberRoleEntity entity = mapper.toEntity(record);
                    entity.setId(id);
                    entity.copyAuditingFrom(existing);
                    return repository.save(entity);
                })
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteMemberRole(Long id) {
        return repository.deleteById(id);
    }
}
