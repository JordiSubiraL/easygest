package com.easygest.customerservice.permision.adapter.in.web;

import com.easygest.customerservice.permision.domain.model.PermisionRecord;

public record PermisionResponse(
        Long id,
        String code,
        String description) {

    public static PermisionResponse from(PermisionRecord record) {
        return new PermisionResponse(record.id(), record.code(), record.description());
    }
}
