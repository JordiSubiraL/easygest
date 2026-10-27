package com.easygest.customerservice.roles.adapter.out.persistence;

import com.easygest.customerservice.roles.domain.model.RolesRecord;
import org.springframework.stereotype.Component;

@Component
public class RolesMapper {

    public RolesRecord toDomain(RolesEntity entity) {
        return new RolesRecord(entity.getId(), entity.getSocietyId(), entity.getCode(), entity.getDescription());
    }

    public RolesEntity toEntity(RolesRecord domain) {
        return new RolesEntity(domain.id(), domain.societyId(), domain.code(), domain.description());
    }
}
