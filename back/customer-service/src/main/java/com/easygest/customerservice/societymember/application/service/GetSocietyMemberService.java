package com.easygest.customerservice.societymember.application.service;

import com.easygest.customerservice.societymember.application.port.in.GetSocietyMemberUseCase;
import com.easygest.customerservice.societymember.application.port.out.SocietyMemberRepositoryPort;
import com.easygest.customerservice.societymember.domain.model.SocietyMemberRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class GetSocietyMemberService implements GetSocietyMemberUseCase {

    private final SocietyMemberRepositoryPort repositoryPort;

    @Override
    public Flux<SocietyMemberRecord> getAllSocietyMembers() {
        return repositoryPort.getAllSocietyMembers();
    }

    @Override
    public Mono<SocietyMemberRecord> getSocietyMemberById(Long id) {
        return repositoryPort.getSocietyMemberById(id);
    }
}
