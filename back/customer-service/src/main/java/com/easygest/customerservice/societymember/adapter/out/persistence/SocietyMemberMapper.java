package com.easygest.customerservice.societymember.adapter.out.persistence;

import com.easygest.customerservice.societymember.domain.model.SocietyMemberRecord;
import org.springframework.stereotype.Component;

@Component
public class SocietyMemberMapper {

    public SocietyMemberRecord toDomain(SocietyMemberEntity entity) {
        return new SocietyMemberRecord(entity.getId(), entity.getUserId(), entity.getSocietyId(),
                entity.getStatusId(), entity.isOwner());
    }

    public SocietyMemberEntity toEntity(SocietyMemberRecord record) {
        return new SocietyMemberEntity(record.id(), record.userId(), record.societyId(),
                record.statusId(), record.isOwner());
    }
}
