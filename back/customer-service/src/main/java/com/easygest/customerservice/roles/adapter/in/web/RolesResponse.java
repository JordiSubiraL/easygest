package com.easygest.customerservice.roles.adapter.in.web;

import com.easygest.customerservice.roles.domain.model.RolesRecord;

public record RolesResponse(
        Long id,
        Long societyId,
        String code,
        String description
) {
    public static RolesResponse from(RolesRecord domain) {
        return new RolesResponse(domain.id(), domain.societyId(), domain.code(), domain.description());
    }
}
