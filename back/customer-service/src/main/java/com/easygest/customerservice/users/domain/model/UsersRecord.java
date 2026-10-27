package com.easygest.customerservice.users.domain.model;

import java.time.LocalDateTime;
import java.util.UUID;

public record UsersRecord(
        Long id,
        String name,
        String surname,
        String email,
        LocalDateTime birthDate,
        UUID externalId) {
}
