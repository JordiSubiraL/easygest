package com.easygest.customerservice.address.adapter.out.persistence;

import com.easygest.customerservice.address.domain.model.AddressRecord;
import org.springframework.stereotype.Component;

@Component
public class AddressMapper {

    public AddressRecord toDomain(AddressEntity entity){
        return new AddressRecord(entity.getId(), entity.getAdmDivId(), entity.getPostalCode(), entity.getStreet(), entity.getAdditionalInfo());
    }

    public AddressEntity toEntity(AddressRecord domain){
        return new AddressEntity(domain.id(),domain.admDivId(),domain.postalCode(), domain.street(), domain.additionalInfo());
    }
}
