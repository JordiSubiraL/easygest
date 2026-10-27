package com.easygest.customerservice.societymember.application.port.in;

import com.easygest.customerservice.societymember.domain.model.SocietyMemberRecord;
import reactor.core.publisher.Mono;

public interface ManageSocietyMemberUseCase {

    Mono<SocietyMemberRecord> createSocietyMember(SocietyMemberRecord record);

    Mono<SocietyMemberRecord> updateSocietyMember(Long id, SocietyMemberRecord record);

    Mono<Void> deleteSocietyMember(Long id);
}
