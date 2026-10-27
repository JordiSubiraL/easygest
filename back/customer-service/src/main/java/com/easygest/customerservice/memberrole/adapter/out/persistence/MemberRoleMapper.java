package com.easygest.customerservice.memberrole.adapter.out.persistence;

import com.easygest.customerservice.memberrole.domain.model.MemberRoleRecord;
import org.springframework.stereotype.Component;

@Component
public class MemberRoleMapper {

    public MemberRoleRecord toDomain(MemberRoleEntity entity) {
        return new MemberRoleRecord(entity.getId(), entity.getRoleId(), entity.getMemberId());
    }

    public MemberRoleEntity toEntity(MemberRoleRecord record) {
        return new MemberRoleEntity(record.id(), record.roleId(), record.memberId());
    }
}
