package com.easygest.customerservice.administrativedivision.domain.model;

public record AdministrativeDivisionRecord(
        Long id,
        Long countryId,
        Long admDivTypeId,
        Long parentId,
        String code,
        String description) {
}
