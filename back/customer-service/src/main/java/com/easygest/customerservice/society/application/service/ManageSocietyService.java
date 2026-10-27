package com.easygest.customerservice.society.application.service;

import com.easygest.customerservice.society.application.port.in.ManageSocietyUseCase;
import com.easygest.customerservice.society.application.port.out.SocietyRepositoryPort;
import com.easygest.customerservice.common.NotFoundException;
import com.easygest.customerservice.society.domain.model.SocietyRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ManageSocietyService implements ManageSocietyUseCase {

    private final SocietyRepositoryPort repositoryPort;

    @Override
    public Mono<SocietyRecord> createSociety(SocietyRecord record) {
        SocietyRecord society = record.publicId() == null
                ? new SocietyRecord(null, UUID.randomUUID(), record.name(), record.legalName(), record.addressId(),
                record.taxIdentificationNumber(), record.email(), record.phone(), record.businessTypeId(),
                record.defaultCurrency())
                : record;
        return repositoryPort.createSociety(society);
    }

    @Override
    public Mono<SocietyRecord> updateSociety(Long id, SocietyRecord record) {
        return repositoryPort.getSocietyById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Society not found with id " + id)))
                .flatMap(existing -> {
                    SocietyRecord updated = record.publicId() == null
                            ? new SocietyRecord(record.id(), existing.publicId(), record.name(), record.legalName(),
                            record.addressId(), record.taxIdentificationNumber(), record.email(), record.phone(),
                            record.businessTypeId(), record.defaultCurrency())
                            : record;
                    return repositoryPort.updateSociety(id, updated);
                });
    }

    @Override
    public Mono<Void> deleteSociety(Long id) {
        return repositoryPort.getSocietyById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Society not found with id " + id)))
                .flatMap(existing -> repositoryPort.deleteSociety(id));
    }
}
