package com.easygest.customerservice.administrativedivisiontype.adapter.out.persistence;

import com.easygest.customerservice.country.adapter.out.persistence.CountryR2dbcRepository;
import com.easygest.customerservice.administrativedivisiontype.application.port.out.AdministrativeDivisionTypeRepositoryPort;
import com.easygest.customerservice.administrativedivisiontype.domain.model.AdministrativeDivisionTypeRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class AdministrativeDivisionTypeRepositoryAdapter implements AdministrativeDivisionTypeRepositoryPort {

    private final AdministrativeDivisionTypeR2dbcRepository repository;
    private final CountryR2dbcRepository countryRepository;
    private final AdministrativeDivisionTypeMapper mapper;

    @Override
    public Flux<AdministrativeDivisionTypeRecord> getAllAdministrativeDivisionTypes() {
        return repository.findAll()
                .flatMap(this::withCountry);
    }

    @Override
    public Mono<AdministrativeDivisionTypeRecord> getAdministrativeDivisionTypeById(Long id) {
        return repository.findById(id).flatMap(this::withCountry);
    }

    @Override
    public Mono<AdministrativeDivisionTypeRecord> getAdministrativeDivisionTypeByCode(String code) {
        return repository.findByCode(code).flatMap(this::withCountry);
    }

    @Override
    public Mono<AdministrativeDivisionTypeRecord> createAdministrativeDivisionType(
            AdministrativeDivisionTypeRecord record) {
        return repository.save(mapper.toEntity(record)).flatMap(this::withCountry);
    }

    @Override
    public Mono<AdministrativeDivisionTypeRecord> updateAdministrativeDivisionType(
            Long id, AdministrativeDivisionTypeRecord record) {
        return repository.findById(id)
                .flatMap(existing -> {
                    AdministrativeDivisionTypeEntity entity = mapper.toEntity(record);
                    entity.setId(id);
                    entity.copyAuditingFrom(existing);
                    return repository.save(entity);
                })
                .flatMap(this::withCountry);
    }

    @Override
    public Mono<Void> deleteAdministrativeDivisionType(Long id) {
        return repository.deleteById(id);
    }

    private Mono<AdministrativeDivisionTypeRecord> withCountry(AdministrativeDivisionTypeEntity entity) {
        return countryRepository.findById(entity.getCountryId())
                .map(country -> mapper.toDomain(entity, country));
    }
}
