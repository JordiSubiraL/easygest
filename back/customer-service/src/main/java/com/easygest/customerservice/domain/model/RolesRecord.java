package com.easygest.customerservice.domain.model;

public record RolesRecord(
        Long id,
        String code,
        String description,
        boolean create_role,
        boolean update_role,
        boolean delete_role) {

}
