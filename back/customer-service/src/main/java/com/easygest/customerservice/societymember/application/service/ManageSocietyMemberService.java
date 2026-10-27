package com.easygest.customerservice.societymember.application.service;

import com.easygest.customerservice.societymember.application.port.in.ManageSocietyMemberUseCase;
import com.easygest.customerservice.societymember.application.port.out.SocietyMemberRepositoryPort;
import com.easygest.customerservice.common.NotFoundException;
import com.easygest.customerservice.societymember.domain.model.SocietyMemberRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ManageSocietyMemberService implements ManageSocietyMemberUseCase {

    private final SocietyMemberRepositoryPort repositoryPort;

    @Override
    public Mono<SocietyMemberRecord> createSocietyMember(SocietyMemberRecord record) {
        return repositoryPort.createSocietyMember(record);
    }

    @Override
    public Mono<SocietyMemberRecord> updateSocietyMember(Long id, SocietyMemberRecord record) {
        return repositoryPort.getSocietyMemberById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Society member not found with id " + id)))
                .flatMap(existing -> repositoryPort.updateSocietyMember(id, record));
    }

    @Override
    public Mono<Void> deleteSocietyMember(Long id) {
        return repositoryPort.getSocietyMemberById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Society member not found with id " + id)))
                .flatMap(existing -> repositoryPort.deleteSocietyMember(id));
    }
}
