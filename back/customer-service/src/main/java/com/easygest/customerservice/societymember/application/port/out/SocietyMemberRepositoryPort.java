package com.easygest.customerservice.societymember.application.port.out;

import com.easygest.customerservice.societymember.domain.model.SocietyMemberRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SocietyMemberRepositoryPort {

    Flux<SocietyMemberRecord> getAllSocietyMembers();

    Mono<SocietyMemberRecord> getSocietyMemberById(Long id);

    Mono<SocietyMemberRecord> createSocietyMember(SocietyMemberRecord record);

    Mono<SocietyMemberRecord> updateSocietyMember(Long id, SocietyMemberRecord record);

    Mono<Void> deleteSocietyMember(Long id);
}
