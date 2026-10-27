package com.easygest.customerservice.society.adapter.out.persistence;

import com.easygest.customerservice.society.domain.model.SocietyRecord;
import org.springframework.stereotype.Component;

@Component
public class SocietyMapper {

    public SocietyRecord toDomain(SocietyEntity entity) {
        return new SocietyRecord(entity.getId(), entity.getPublicId(), entity.getName(), entity.getLegalName(),
                entity.getAddressId(), entity.getTaxIdentificationNumber(), entity.getEmail(), entity.getPhone(),
                entity.getBusinessTypeId(), entity.getDefaultCurrency());
    }

    public SocietyEntity toEntity(SocietyRecord record) {
        return new SocietyEntity(record.id(), record.publicId(), record.name(), record.legalName(),
                record.addressId(), record.taxIdentificationNumber(), record.email(), record.phone(),
                record.businessTypeId(), record.defaultCurrency());
    }
}
