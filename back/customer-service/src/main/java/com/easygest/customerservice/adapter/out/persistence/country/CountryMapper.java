package com.easygest.customerservice.adapter.out.persistence.country;

import com.easygest.customerservice.domain.model.CountryRecord;
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
