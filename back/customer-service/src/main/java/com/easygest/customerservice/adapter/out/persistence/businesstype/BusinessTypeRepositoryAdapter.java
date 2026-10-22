package com.easygest.customerservice.adapter.out.persistence.businesstype;

import com.easygest.customerservice.application.port.out.businesstype.BusinessTypeRepositoryPort;
import com.easygest.customerservice.domain.model.BusinessTypeRecord;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
public class BusinessTypeRepositoryAdapter implements BusinessTypeRepositoryPort {

 private final BusinessTypeR2dbcRepository repository;
 private final BusinessTypeMapper mapper;

 public Flux<BusinessTypeRecord> getAllBusinessTypes() {
  return repository.findAll().map(mapper::toDomain);
 }

 public Mono<BusinessTypeRecord> getBusinessTypeByCode(String code){
     return repository.findByCode(code).map(mapper::toDomain);
 }
}
