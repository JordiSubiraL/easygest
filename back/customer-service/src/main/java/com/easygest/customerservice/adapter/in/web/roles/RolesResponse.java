package com.easygest.customerservice.adapter.in.web.roles;

import com.easygest.customerservice.domain.model.RolesRecord;

public record RolesResponse(
    Long id,
    String code,
    String description,
    Boolean create_role,
    Boolean update_role,
    Boolean delete_role
) {
    static RolesResponse from(RolesRecord domain){
        return new RolesResponse(domain.id(), domain.code(), domain.description(), domain.create_role(), domain.update_role(), domain.delete_role());
    }
}
