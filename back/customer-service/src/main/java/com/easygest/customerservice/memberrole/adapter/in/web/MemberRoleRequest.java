package com.easygest.customerservice.memberrole.adapter.in.web;

import com.easygest.customerservice.memberrole.domain.model.MemberRoleRecord;
import jakarta.validation.constraints.NotNull;

public record MemberRoleRequest(
        @NotNull Long roleId,
        @NotNull Long memberId) {

    public MemberRoleRecord toRecord() {
        return new MemberRoleRecord(null, roleId, memberId);
    }

    public MemberRoleRecord toRecord(Long id) {
        return new MemberRoleRecord(id, roleId, memberId);
    }
}
