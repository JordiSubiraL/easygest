package com.easygest.customerservice.administrativedivisiontype.application.port.in;

import com.easygest.customerservice.administrativedivisiontype.domain.model.AdministrativeDivisionTypeRecord;
import reactor.core.publisher.Mono;

public interface ManageAdministrativeDivisionTypeUseCase {

    Mono<AdministrativeDivisionTypeRecord> createAdministrativeDivisionType(
            AdministrativeDivisionTypeRecord record);

    Mono<AdministrativeDivisionTypeRecord> updateAdministrativeDivisionType(
            Long id, AdministrativeDivisionTypeRecord record);

    Mono<Void> deleteAdministrativeDivisionType(Long id);
}
