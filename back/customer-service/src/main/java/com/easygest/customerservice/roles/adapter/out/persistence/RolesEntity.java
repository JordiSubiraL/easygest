package com.easygest.customerservice.roles.adapter.out.persistence;

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
@Table("roles")
public class RolesEntity extends AuditableEntity {

    @Id
    private Long id;
    private Long societyId;
    private String code;
    private String description;

}
