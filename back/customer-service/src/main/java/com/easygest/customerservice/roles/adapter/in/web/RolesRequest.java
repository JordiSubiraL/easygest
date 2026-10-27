package com.easygest.customerservice.roles.adapter.in.web;

import com.easygest.customerservice.roles.domain.model.RolesRecord;
import jakarta.validation.constraints.NotBlank;

public record RolesRequest(
        Long societyId,
        @NotBlank String code,
        @NotBlank String description) {

    public RolesRecord toRecord() {
        return new RolesRecord(null, societyId, code, description);
    }

    public RolesRecord toRecord(Long id) {
        return new RolesRecord(id, societyId, code, description);
    }
}
