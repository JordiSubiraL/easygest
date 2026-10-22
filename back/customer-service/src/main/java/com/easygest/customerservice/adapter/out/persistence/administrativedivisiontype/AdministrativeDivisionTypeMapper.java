package com.easygest.customerservice.adapter.out.persistence.administrativedivisiontype;

import com.easygest.customerservice.adapter.out.persistence.country.CountryEntity;
import com.easygest.customerservice.adapter.out.persistence.country.CountryMapper;
import com.easygest.customerservice.domain.model.AdministrativeDivisionTypeRecord;
import com.easygest.customerservice.domain.model.CountryRecord;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AdministrativeDivisionTypeMapper
{

    private CountryMapper countryMapper;

    public AdministrativeDivisionTypeRecord toDomain(AdministrativeDivisionTypeEntity entity, CountryEntity country){
        return new AdministrativeDivisionTypeRecord(entity.getId(), entity.getCode(),entity.getDescription(), countryMapper.toDomain(country));
    }

    public AdministrativeDivisionTypeEntity toEntity(AdministrativeDivisionTypeRecord record){
        return new AdministrativeDivisionTypeEntity(record.id(), record.code(), record.description(), record.country().id());
    }
}
