package com.easygest.customerservice.administrativedivision.adapter.out.persistence;

import com.easygest.customerservice.common.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table("administrative_division")
public class AdministrativeDivisionEntity extends AuditableEntity {

    @Id
    private Long id;
    private Long countryId;
    private Long admDivTypeId;
    private Long parentId;
    private String code;
    private String description;
}
