package com.easygest.customerservice.memberrole.adapter.out.persistence;

import com.easygest.customerservice.common.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("member_role")
public class MemberRoleEntity extends AuditableEntity {

    @Id
    private Long id;
    private Long roleId;
    private Long memberId;

}
