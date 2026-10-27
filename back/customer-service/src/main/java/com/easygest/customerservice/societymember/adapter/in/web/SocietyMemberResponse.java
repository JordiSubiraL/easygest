package com.easygest.customerservice.societymember.adapter.in.web;

import com.easygest.customerservice.societymember.domain.model.SocietyMemberRecord;

public record SocietyMemberResponse(
        Long id,
        Long userId,
        Long societyId,
        Long statusId,
        boolean isOwner) {

    public static SocietyMemberResponse from(SocietyMemberRecord record) {
        return new SocietyMemberResponse(record.id(), record.userId(), record.societyId(),
                record.statusId(), record.isOwner());
    }
}
