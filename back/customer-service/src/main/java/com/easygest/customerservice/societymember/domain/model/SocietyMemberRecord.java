package com.easygest.customerservice.societymember.domain.model;

public record SocietyMemberRecord(
        Long id,
        Long userId,
        Long societyId,
        Long statusId,
        boolean isOwner) {
}
