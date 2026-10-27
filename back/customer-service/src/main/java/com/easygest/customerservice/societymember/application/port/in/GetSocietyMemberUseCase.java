package com.easygest.customerservice.societymember.application.port.in;

import com.easygest.customerservice.societymember.domain.model.SocietyMemberRecord;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface GetSocietyMemberUseCase {

    Flux<SocietyMemberRecord> getAllSocietyMembers();

    Mono<SocietyMemberRecord> getSocietyMemberById(Long id);
}
