package com.easygest.customerservice.domain.model;

public record CountryRecord(
    Long id,
    String code,
    String description,
    String prefix
) {
}
