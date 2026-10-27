package com.easygest.customerservice.businesstype.adapter.out.persistence;

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
@Table("business_type")
public class BusinessTypeEntity extends AuditableEntity {

    @Id
    private Long id;
    private String code;
    private String description;

}
