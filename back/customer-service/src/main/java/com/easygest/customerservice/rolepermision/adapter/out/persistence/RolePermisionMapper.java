package com.easygest.customerservice.rolepermision.adapter.out.persistence;

import com.easygest.customerservice.rolepermision.domain.model.RolePermisionRecord;
import org.springframework.stereotype.Component;

@Component
public class RolePermisionMapper {

    public RolePermisionRecord toDomain(RolePermisionEntity entity) {
        return new RolePermisionRecord(entity.getId(), entity.getRoleId(), entity.getPermisionId());
    }

    public RolePermisionEntity toEntity(RolePermisionRecord record) {
        return new RolePermisionEntity(record.id(), record.roleId(), record.permisionId());
    }
}
