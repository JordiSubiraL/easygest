package com.easygest.customerservice.users.adapter.in.web;

import com.easygest.customerservice.users.domain.model.UsersRecord;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.UUID;

public record UsersRequest(
        @NotBlank String name,
        @NotBlank String surname,
        @NotBlank @Email String email,
        LocalDateTime birthDate,
        UUID externalId) {

    public UsersRecord toRecord() {
        return new UsersRecord(null, name, surname, email, birthDate, externalId);
    }

    public UsersRecord toRecord(Long id) {
        return new UsersRecord(id, name, surname, email, birthDate, externalId);
    }
}
