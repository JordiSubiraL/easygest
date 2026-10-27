package com.easygest.customerservice.common;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class AuditableEntity {

    @CreatedDate
    private LocalDateTime createDate;

    @LastModifiedDate
    private LocalDateTime modifyDate;

    @CreatedBy
    private String createUser;

    @LastModifiedBy
    private String modifyUser;

    @Version
    private Long version = 0L;

    public void copyAuditingFrom(AuditableEntity source) {
        this.createDate = source.createDate;
        this.createUser = source.createUser;
        this.modifyDate = source.modifyDate;
        this.modifyUser = source.modifyUser;
        this.version = source.version;
    }
}
