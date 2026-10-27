package com.easygest.customerservice.businesstype.adapter.in.web;

import com.easygest.customerservice.businesstype.domain.model.BusinessTypeRecord;

public record BusinessTypeResponse(
        Long id,
        String code,
        String description) {

    public static BusinessTypeResponse from(BusinessTypeRecord record) {
        return new BusinessTypeResponse(record.id(), record.code(), record.description());
    }
}
