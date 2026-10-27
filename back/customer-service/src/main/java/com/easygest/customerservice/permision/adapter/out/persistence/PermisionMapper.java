package com.easygest.customerservice.permision.adapter.out.persistence;

import com.easygest.customerservice.permision.domain.model.PermisionRecord;
import org.springframework.stereotype.Component;

@Component
public class PermisionMapper {

    public PermisionRecord toDomain(PermisionEntity entity) {
        return new PermisionRecord(entity.getId(), entity.getCode(), entity.getDescription());
    }

    public PermisionEntity toEntity(PermisionRecord record) {
        return new PermisionEntity(record.id(), record.code(), record.description());
    }
}
