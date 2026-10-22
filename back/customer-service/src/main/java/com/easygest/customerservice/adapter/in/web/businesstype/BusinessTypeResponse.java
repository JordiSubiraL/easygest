package com.easygest.customerservice.adapter.in.web.businesstype;

public record BusinessTypeResponse(
        String code,
        String description
) {
    static BusinessTypeResponse from(com.easygest.customerservice.domain.model.BusinessTypeRecord b) {
        return new BusinessTypeResponse(b.code(), b.description());
    }
}
