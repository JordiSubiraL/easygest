package com.easygest.customerservice.memberrole.adapter.in.web;

import com.easygest.customerservice.memberrole.domain.model.MemberRoleRecord;

public record MemberRoleResponse(
        Long id,
        Long roleId,
        Long memberId) {

    public static MemberRoleResponse from(MemberRoleRecord record) {
        return new MemberRoleResponse(record.id(), record.roleId(), record.memberId());
    }
}
