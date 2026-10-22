package com.easygest.customerservice.adapter.out.persistence.country;

import com.easygest.customerservice.common.AuditableEntity;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("country")
public class CountryEntity extends AuditableEntity {

    @Id
    private Long id;
    private String code;
    private String description;
    private String prefix;
}
