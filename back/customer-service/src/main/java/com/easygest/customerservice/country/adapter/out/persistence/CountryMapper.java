package com.easygest.customerservice.country.adapter.out.persistence;

import com.easygest.customerservice.country.domain.model.CountryRecord;
import org.springframework.stereotype.Component;

@Component
public class CountryMapper {

    public CountryRecord toDomain(CountryEntity entity) {
        return new CountryRecord(entity.getId(), entity.getCode(), entity.getDescription(), entity.getPrefix());
    }

    public CountryEntity toEntity(CountryRecord domain) {
        return new CountryEntity(domain.id(), domain.code(), domain.description(), domain.prefix());
    }
}
