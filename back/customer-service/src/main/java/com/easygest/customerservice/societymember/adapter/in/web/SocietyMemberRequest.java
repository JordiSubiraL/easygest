package com.easygest.customerservice.societymember.adapter.in.web;

import com.easygest.customerservice.societymember.domain.model.SocietyMemberRecord;
import jakarta.validation.constraints.NotNull;

public record SocietyMemberRequest(
        @NotNull Long userId,
        @NotNull Long societyId,
        Long statusId,
        boolean isOwner) {

    public SocietyMemberRecord toRecord() {
        return new SocietyMemberRecord(null, userId, societyId, statusId, isOwner);
    }

    public SocietyMemberRecord toRecord(Long id) {
        return new SocietyMemberRecord(id, userId, societyId, statusId, isOwner);
    }
}
