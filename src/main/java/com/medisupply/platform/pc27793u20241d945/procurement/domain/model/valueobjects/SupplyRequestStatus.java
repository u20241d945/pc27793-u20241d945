package com.medisupply.platform.pc27793u20241d945.procurement.domain.model.valueobjects;


public enum SupplyRequestStatus {
    PENDING,
    APPROVED,
    FULFILLED,
    CANCELLED
    ;

    public static SupplyRequestStatus from(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Request status is required");
        }
        try {
            return SupplyRequestStatus.valueOf(value.trim());
        } catch (IllegalArgumentException exception) {
            throw new IllegalArgumentException(
                    "Request status must be PENDING, APPROVED, FULFILLED or CANCELLED");
        }
    }
}
