package com.easygest.customerservice.adapter.out.persistence.administrativedivisiontype;

import com.easygest.customerservice.adapter.out.persistence.country.CountryR2dbcRepository;
import com.easygest.customerservice.application.port.out.administrativedivisiontype.AdministrativeDivisionTypeRepositoryPort;
import com.easygest.customerservice.domain.model.AdministrativeDivisionTypeRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AdminitrativeDivisionTypeRepositoryAdapter implements AdministrativeDivisionTypeRepositoryPort {

    private final AdministrativeDivisionTypeR2dbcRepository administrativeDivisionTypeR2dbcRepository;
    private final CountryR2dbcRepository countryR2dbcRepository;
    private final AdministrativeDivisionTypeMapper mapper;

    @Override
    public Flux<AdministrativeDivisionTypeRecord> getAllAdministrativeDivisionTypes() {
        return administrativeDivisionTypeR2dbcRepository.findAll()
                .flatMap( adm_type -> countryR2dbcRepository.findById(adm_type.getCountryId())
                .map(country -> mapper.toDomain(adm_type, country)));
    }

    @Override
    public Mono<AdministrativeDivisionTypeRecord> getAdminitrativeDivisionTypeByCode(String code) {
        return administrativeDivisionTypeR2dbcRepository.findByCode(code)
                .flatMap(adm_type -> countryR2dbcRepository.findById(adm_type.getCountryId())
                .map(country -> mapper.toDomain(adm_type, country)));
    }
}
