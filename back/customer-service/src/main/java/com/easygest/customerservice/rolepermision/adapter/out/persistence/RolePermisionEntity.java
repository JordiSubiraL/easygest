package com.easygest.customerservice.rolepermision.adapter.out.persistence;

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
@Table("role_permision")
public class RolePermisionEntity extends AuditableEntity {

    @Id
    private Long id;
    private Long roleId;
    private Long permisionId;
}
