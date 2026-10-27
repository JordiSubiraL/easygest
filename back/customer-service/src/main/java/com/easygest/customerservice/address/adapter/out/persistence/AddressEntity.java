package com.easygest.customerservice.address.adapter.out.persistence;

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
@Table("address")
public class AddressEntity extends AuditableEntity {

    @Id
    Long id;
    Long admDivId;
    String postalCode;
    String street;
    String additionalInfo;
}
