package com.easygest.customerservice.adapter.out.persistence.administrativedivisiontype;

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
@Table("administrative_division_type")
public class AdministrativeDivisionTypeEntity {

    @Id
    private Long id;
    private String code;
    private String description;
    private Long countryId;

}
