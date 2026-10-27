package com.easygest.customerservice.status.adapter.in.web;

import com.easygest.customerservice.status.domain.model.StatusRecord;

public record StatusResponse(
        Long id,
        String code,
        String description) {

    public static StatusResponse from(StatusRecord record) {
        return new StatusResponse(record.id(), record.code(), record.description());
    }
}
