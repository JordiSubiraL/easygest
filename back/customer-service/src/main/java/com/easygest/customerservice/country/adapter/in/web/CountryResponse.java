package com.easygest.customerservice.country.adapter.in.web;

import com.easygest.customerservice.country.domain.model.CountryRecord;

public record CountryResponse(
        Long id,
        String code,
        String description,
        String prefix) {

    public static CountryResponse from(CountryRecord record) {
        return new CountryResponse(record.id(), record.code(), record.description(), record.prefix());
    }
}
