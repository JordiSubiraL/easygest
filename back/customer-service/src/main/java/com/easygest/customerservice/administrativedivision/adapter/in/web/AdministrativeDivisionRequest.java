package com.easygest.customerservice.administrativedivision.adapter.in.web;

import com.easygest.customerservice.administrativedivision.domain.model.AdministrativeDivisionRecord;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AdministrativeDivisionRequest(
        @NotNull Long countryId,
        @NotNull Long admDivTypeId,
        Long parentId,
        @NotBlank String code,
        @NotBlank String description) {

    public AdministrativeDivisionRecord toRecord() {
        return new AdministrativeDivisionRecord(null, countryId, admDivTypeId, parentId, code, description);
    }

    public AdministrativeDivisionRecord toRecord(Long id) {
        return new AdministrativeDivisionRecord(id, countryId, admDivTypeId, parentId, code, description);
    }
}
