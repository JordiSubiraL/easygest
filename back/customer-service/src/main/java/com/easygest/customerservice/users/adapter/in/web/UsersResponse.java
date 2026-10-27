package com.easygest.customerservice.users.adapter.in.web;

import com.easygest.customerservice.users.domain.model.UsersRecord;

import java.time.LocalDateTime;
import java.util.UUID;

public record UsersResponse(
        Long id,
        String name,
        String surname,
        String email,
        LocalDateTime birthDate,
        UUID externalId) {

    public static UsersResponse from(UsersRecord record) {
        return new UsersResponse(record.id(), record.name(), record.surname(), record.email(),
                record.birthDate(), record.externalId());
    }
}
