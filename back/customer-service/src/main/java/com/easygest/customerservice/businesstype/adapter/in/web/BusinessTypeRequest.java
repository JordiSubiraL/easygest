package com.easygest.customerservice.businesstype.adapter.in.web;

import com.easygest.customerservice.businesstype.domain.model.BusinessTypeRecord;
import jakarta.validation.constraints.NotBlank;

public record BusinessTypeRequest(
        @NotBlank String code,
        @NotBlank String description) {

    public BusinessTypeRecord toRecord() {
        return new BusinessTypeRecord(null, code, description);
    }

    public BusinessTypeRecord toRecord(Long id) {
        return new BusinessTypeRecord(id, code, description);
    }
}
