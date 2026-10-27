package com.easygest.customerservice.administrativedivisiontype.domain.model;

public record AdministrativeDivisionTypeRecord(
        Long id,
        String code,
        String description,
        Long countryId,
        String countryCode) {
}
