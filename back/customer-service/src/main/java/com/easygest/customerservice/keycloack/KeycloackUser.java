package com.easygest.customerservice.keycloack;

public record KeycloackUser(String id, String username, String email, String firstName, String lastName, Boolean enabled) {
}
