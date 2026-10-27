package com.easygest.customerservice.businesstype.application.service;

import com.easygest.customerservice.businesstype.application.port.in.ManageBusinessTypeUseCase;
import com.easygest.customerservice.businesstype.application.port.out.BusinessTypeRepositoryPort;
import com.easygest.customerservice.common.NotFoundException;
import com.easygest.customerservice.businesstype.domain.model.BusinessTypeRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ManageBusinessTypeService implements ManageBusinessTypeUseCase {

    private final BusinessTypeRepositoryPort repositoryPort;

    @Override
    public Mono<BusinessTypeRecord> createBusinessType(BusinessTypeRecord record) {
        return repositoryPort.createBusinessType(record);
    }

    @Override
    public Mono<BusinessTypeRecord> updateBusinessType(Long id, BusinessTypeRecord record) {
        return repositoryPort.getBusinessTypeById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Business type not found with id " + id)))
                .flatMap(existing -> repositoryPort.updateBusinessType(id, record));
    }

    @Override
    public Mono<Void> deleteBusinessType(Long id) {
        return repositoryPort.getBusinessTypeById(id)
                .switchIfEmpty(Mono.error(new NotFoundException("Business type not found with id " + id)))
                .flatMap(existing -> repositoryPort.deleteBusinessType(id));
    }
}
