package com.easygest.customerservice.society.adapter.in.web;

import com.easygest.customerservice.society.domain.model.SocietyRecord;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.UUID;

public record SocietyRequest(
        UUID publicId,
        @NotBlank String name,
        String legalName,
        @NotNull Long addressId,
        String taxIdentificationNumber,
        @NotBlank @Email String email,
        String phone,
        @NotNull Long businessTypeId,
        @NotBlank String defaultCurrency) {

    public SocietyRecord toRecord() {
        return new SocietyRecord(null, publicId, name, legalName, addressId, taxIdentificationNumber,
                email, phone, businessTypeId, defaultCurrency);
    }

    public SocietyRecord toRecord(Long id) {
        return new SocietyRecord(id, publicId, name, legalName, addressId, taxIdentificationNumber,
                email, phone, businessTypeId, defaultCurrency);
    }
}
