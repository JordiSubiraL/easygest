package com.easygest.customerservice.society.adapter.in.web;

import com.easygest.customerservice.society.domain.model.SocietyRecord;

import java.util.UUID;

public record SocietyResponse(
        Long id,
        UUID publicId,
        String name,
        String legalName,
        Long addressId,
        String taxIdentificationNumber,
        String email,
        String phone,
        Long businessTypeId,
        String defaultCurrency) {

    public static SocietyResponse from(SocietyRecord record) {
        return new SocietyResponse(record.id(), record.publicId(), record.name(), record.legalName(),
                record.addressId(), record.taxIdentificationNumber(), record.email(), record.phone(),
                record.businessTypeId(), record.defaultCurrency());
    }
}
