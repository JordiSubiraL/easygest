package com.easygest.customerservice.adapter.out.persistence.roles;

import com.easygest.customerservice.domain.model.RolesRecord;
import org.springframework.stereotype.Component;

@Component
public class RolesMapper {

    public RolesRecord toDomain(RolesEntity domain){
        return new RolesRecord(domain.getId(), domain.getCode(), domain.getDescription(), domain.isCreate_role(), domain.isUpdate_role(), domain.isDelete_role());
    }

    public RolesEntity toEntity(RolesRecord domain){
        return new RolesEntity(domain.id(), domain.code(), domain.description(), domain.create_role(), domain.update_role(), domain.delete_role());
    }
}
