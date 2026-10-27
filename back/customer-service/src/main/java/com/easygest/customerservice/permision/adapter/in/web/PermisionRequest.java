package com.easygest.customerservice.permision.adapter.in.web;

import com.easygest.customerservice.permision.domain.model.PermisionRecord;
import jakarta.validation.constraints.NotBlank;

public record PermisionRequest(
        @NotBlank String code,
        @NotBlank String description) {

    public PermisionRecord toRecord() {
        return new PermisionRecord(null, code, description);
    }

    public PermisionRecord toRecord(Long id) {
        return new PermisionRecord(id, code, description);
    }
}
