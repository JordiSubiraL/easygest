package com.easygest.customerservice.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;

import java.sql.Timestamp;

@Getter
@Setter
public abstract class AuditableEntity{

    @CreatedDate
    private Timestamp createDate;

    @LastModifiedDate
    private Timestamp modifyDate;

    @CreatedBy
    private String createUser;

    @LastModifiedBy
    private String modifyUser;

    @Version
    private Integer version;
}
