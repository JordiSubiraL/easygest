package com.easygest.customerservice.administrativedivisiontype.adapter.out.persistence;

import com.easygest.customerservice.country.adapter.out.persistence.CountryEntity;
import com.easygest.customerservice.administrativedivisiontype.domain.model.AdministrativeDivisionTypeRecord;
import org.springframework.stereotype.Component;

@Component
public class AdministrativeDivisionTypeMapper {

    public AdministrativeDivisionTypeRecord toDomain(AdministrativeDivisionTypeEntity entity, CountryEntity country) {
        return new AdministrativeDivisionTypeRecord(entity.getId(), entity.getCode(), entity.getDescription(),
                entity.getCountryId(), country.getCode());
    }

    public AdministrativeDivisionTypeEntity toEntity(AdministrativeDivisionTypeRecord record) {
        return new AdministrativeDivisionTypeEntity(record.id(), record.code(), record.description(),
                record.countryId());
    }
}
