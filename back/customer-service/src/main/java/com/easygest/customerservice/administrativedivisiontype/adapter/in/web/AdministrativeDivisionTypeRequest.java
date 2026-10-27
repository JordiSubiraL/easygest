package com.easygest.customerservice.administrativedivisiontype.adapter.in.web;

import com.easygest.customerservice.administrativedivisiontype.domain.model.AdministrativeDivisionTypeRecord;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AdministrativeDivisionTypeRequest(
        @NotBlank String code,
        @NotBlank String description,
        @NotNull Long countryId) {

    public AdministrativeDivisionTypeRecord toRecord() {
        return new AdministrativeDivisionTypeRecord(null, code, description, countryId, null);
    }

    public AdministrativeDivisionTypeRecord toRecord(Long id) {
        return new AdministrativeDivisionTypeRecord(id, code, description, countryId, null);
    }
}
