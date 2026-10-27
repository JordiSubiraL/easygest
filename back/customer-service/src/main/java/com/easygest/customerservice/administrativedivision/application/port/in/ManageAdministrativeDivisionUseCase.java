package com.easygest.customerservice.administrativedivision.application.port.in;

import com.easygest.customerservice.administrativedivision.domain.model.AdministrativeDivisionRecord;
import reactor.core.publisher.Mono;

public interface ManageAdministrativeDivisionUseCase {

    Mono<AdministrativeDivisionRecord> createAdministrativeDivision(AdministrativeDivisionRecord record);

    Mono<AdministrativeDivisionRecord> updateAdministrativeDivision(Long id, AdministrativeDivisionRecord record);

    Mono<Void> deleteAdministrativeDivision(Long id);
}
