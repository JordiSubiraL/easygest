package com.easygest.customerservice.users.adapter.out.persistence;

import com.easygest.customerservice.users.domain.model.UsersRecord;
import org.springframework.stereotype.Component;

@Component
public class UsersMapper {

    public UsersRecord toDomain(UsersEntity entity) {
        return new UsersRecord(entity.getId(), entity.getName(), entity.getSurname(), entity.getEmail(),
                entity.getBirthDate(), entity.getExternalId());
    }

    public UsersEntity toEntity(UsersRecord record) {
        return new UsersEntity(record.id(), record.surname(), record.name(), record.surname(), record.email(),
                record.birthDate(), record.externalId());
    }
}
