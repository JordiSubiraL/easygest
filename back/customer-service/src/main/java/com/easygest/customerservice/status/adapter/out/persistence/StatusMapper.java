package com.easygest.customerservice.status.adapter.out.persistence;

import com.easygest.customerservice.status.domain.model.StatusRecord;
import org.springframework.stereotype.Component;

@Component
public class StatusMapper {

    public StatusRecord toDomain(StatusEntity entity) {
        return new StatusRecord(entity.getId(), entity.getCode(), entity.getDescription());
    }

    public StatusEntity toEntity(StatusRecord record) {
        return new StatusEntity(record.id(), record.code(), record.description());
    }
}
