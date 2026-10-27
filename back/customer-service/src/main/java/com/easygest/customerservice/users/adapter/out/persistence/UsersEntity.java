package com.easygest.customerservice.users.adapter.out.persistence;

import com.easygest.customerservice.common.AuditableEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table("users")
public class UsersEntity extends AuditableEntity {

    @Id
    private Long id;
    private String username;
    private String name;
    private String surname;
    private String email;
    private LocalDateTime birthDate;
    private UUID externalId;
}
