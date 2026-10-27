package com.easygest.customerservice.businesstype.adapter.out.persistence;

import com.easygest.customerservice.businesstype.domain.model.BusinessTypeRecord;
import org.springframework.stereotype.Component;

@Component
public class BusinessTypeMapper {

    public BusinessTypeRecord toDomain(BusinessTypeEntity entity){
        return new BusinessTypeRecord(entity.getId(), entity.getCode(), entity.getDescription());
    }

    public BusinessTypeEntity toEntity(BusinessTypeRecord record){
        return new BusinessTypeEntity(record.id(), record.code(), record.description());
    }
}
