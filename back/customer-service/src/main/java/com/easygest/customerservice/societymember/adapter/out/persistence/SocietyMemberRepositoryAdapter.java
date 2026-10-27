package com.easygest.customerservice.societymember.adapter.out.persistence;

import com.easygest.customerservice.societymember.application.port.out.SocietyMemberRepositoryPort;
import com.easygest.customerservice.societymember.domain.model.SocietyMemberRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class SocietyMemberRepositoryAdapter implements SocietyMemberRepositoryPort {

    private final SocietyMemberR2dbcRepository repository;
    private final SocietyMemberMapper mapper;

    @Override
    public Flux<SocietyMemberRecord> getAllSocietyMembers() {
        return repository.findAll().map(mapper::toDomain);
    }

    @Override
    public Mono<SocietyMemberRecord> getSocietyMemberById(Long id) {
        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public Mono<SocietyMemberRecord> createSocietyMember(SocietyMemberRecord record) {
        return repository.save(mapper.toEntity(record)).map(mapper::toDomain);
    }

    @Override
    public Mono<SocietyMemberRecord> updateSocietyMember(Long id, SocietyMemberRecord record) {
        return repository.findById(id)
                .flatMap(existing -> {
                    SocietyMemberEntity entity = mapper.toEntity(record);
                    entity.setId(id);
                    entity.copyAuditingFrom(existing);
                    return repository.save(entity);
                })
                .map(mapper::toDomain);
    }

    @Override
    public Mono<Void> deleteSocietyMember(Long id) {
        return repository.deleteById(id);
    }
}
