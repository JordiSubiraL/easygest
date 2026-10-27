package com.easygest.customerservice.rolepermision.adapter.in.web;

import com.easygest.customerservice.rolepermision.domain.model.RolePermisionRecord;

public record RolePermisionResponse(
        Long id,
        Long roleId,
        Long permisionId) {

    public static RolePermisionResponse from(RolePermisionRecord record) {
        return new RolePermisionResponse(record.id(), record.roleId(), record.permisionId());
    }
}
