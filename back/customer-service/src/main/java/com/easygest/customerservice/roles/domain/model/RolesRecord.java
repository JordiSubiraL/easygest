package com.easygest.customerservice.roles.domain.model;

public record RolesRecord(
        Long id,
        Long societyId,
        String code,
        String description) {
}
