package com.easygest.customerservice.society.adapter.out.persistence;

import com.easygest.customerservice.common.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("society")
public class SocietyEntity extends AuditableEntity {

    @Id
    private Long id;
    private UUID publicId;
    private String name;
    private String legalName;
    private Long addressId;
    private String taxIdentificationNumber;
    private String email;
    private String phone;
    private Long businessTypeId;
    private String defaultCurrency;
}
