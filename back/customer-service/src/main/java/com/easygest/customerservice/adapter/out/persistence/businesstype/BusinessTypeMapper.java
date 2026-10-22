package com.easygest.customerservice.adapter.out.persistence.businesstype;

import com.easygest.customerservice.domain.model.BusinessTypeRecord;

public class BusinessTypeMapper {

    public BusinessTypeRecord toDomain(BusinessTypeEntity entity){
        return new BusinessTypeRecord(entity.getId(), entity.getCode(), entity.getDescription());
    }

    public BusinessTypeEntity toEntity(BusinessTypeRecord record){
        return new BusinessTypeEntity(record.id(), record.code(), record.description());
    }
}
