package com.easygest.customerservice.status.adapter.in.web;

import com.easygest.customerservice.status.domain.model.StatusRecord;
import jakarta.validation.constraints.NotBlank;

public record StatusRequest(
        @NotBlank String code,
        @NotBlank String description) {

    public StatusRecord toRecord() {
        return new StatusRecord(null, code, description);
    }

    public StatusRecord toRecord(Long id) {
        return new StatusRecord(id, code, description);
    }
}
