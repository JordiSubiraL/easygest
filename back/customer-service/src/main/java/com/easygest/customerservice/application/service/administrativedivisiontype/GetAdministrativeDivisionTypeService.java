package com.easygest.customerservice.application.service.administrativedivisiontype;

import com.easygest.customerservice.application.port.in.administrativedivisiontype.GetAdministrativeDivisionTypeUseCase;
import com.easygest.customerservice.domain.model.AdministrativeDivisionTypeRecord;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class GetAdministrativeDivisionTypeService implements GetAdministrativeDivisionTypeUseCase {


    @Override
    public Flux<AdministrativeDivisionTypeRecord> getAllAdministrativeDivisionTypes() {
        return null;
    }

    @Override
    public Mono<AdministrativeDivisionTypeRecord> getAdminitrativeDivisionTypeByCode(String code) {
        return null;
    }
}
