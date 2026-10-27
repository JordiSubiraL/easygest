package com.easygest.customerservice.society.domain.model;

import java.util.UUID;

public record SocietyRecord(
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
}
