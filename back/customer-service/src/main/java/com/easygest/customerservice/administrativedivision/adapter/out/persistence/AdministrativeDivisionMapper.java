package com.easygest.customerservice.administrativedivision.adapter.out.persistence;

import com.easygest.customerservice.administrativedivision.domain.model.AdministrativeDivisionRecord;
import org.springframework.stereotype.Component;

@Component
public class AdministrativeDivisionMapper {

    public AdministrativeDivisionRecord toDomain(AdministrativeDivisionEntity entity) {
        return new AdministrativeDivisionRecord(entity.getId(), entity.getCountryId(), entity.getAdmDivTypeId(),
                entity.getParentId(), entity.getCode(), entity.getDescription());
    }

    public AdministrativeDivisionEntity toEntity(AdministrativeDivisionRecord record) {
        return new AdministrativeDivisionEntity(record.id(), record.countryId(), record.admDivTypeId(),
                record.parentId(), record.code(), record.description());
    }
}
