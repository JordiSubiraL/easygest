package com.easygest.customerservice.adapter.out.persistence.society;

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
public class SocietyEntity {

    @Id
    private Long id;
    private UUID publicId;
    private String name;
    private String legalName;
}
