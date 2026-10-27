package com.easygest.customerservice.societymember.adapter.out.persistence;

import com.easygest.customerservice.common.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("society_member")
public class SocietyMemberEntity extends AuditableEntity {

    @Id
    private Long id;
    private Long userId;
    private Long societyId;
    private Long statusId;
    @Column("is_owner")
    private boolean isOwner;

}
