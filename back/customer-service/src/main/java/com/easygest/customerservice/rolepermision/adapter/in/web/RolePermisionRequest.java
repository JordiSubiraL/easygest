package com.easygest.customerservice.rolepermision.adapter.in.web;

import com.easygest.customerservice.rolepermision.domain.model.RolePermisionRecord;
import jakarta.validation.constraints.NotNull;

public record RolePermisionRequest(
        @NotNull Long roleId,
        @NotNull Long permisionId) {

    public RolePermisionRecord toRecord() {
        return new RolePermisionRecord(null, roleId, permisionId);
    }

    public RolePermisionRecord toRecord(Long id) {
        return new RolePermisionRecord(id, roleId, permisionId);
    }
}
