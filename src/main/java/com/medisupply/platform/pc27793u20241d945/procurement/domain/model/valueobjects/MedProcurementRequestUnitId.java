package com.medisupply.platform.pc27793u20241d945.procurement.domain.model.valueobjects;

import java.util.Objects;
import java.util.UUID;

/**
 * Stable business identifier assigned to a unit.
 *
 * @param value UUID value
 * @author Gabriel Yanac Flores
 */
public record MedProcurementRequestUnitId(UUID value) {

    public MedProcurementRequestUnitId {
        Objects.requireNonNull(value, "Unit ID cannot be null");
    }

    public static MedProcurementRequestUnitId generate() {
        return new MedProcurementRequestUnitId(UUID.randomUUID());
    }

    public static MedProcurementRequestUnitId from(String value) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("Unit ID cannot be blank");
        }
        return new MedProcurementRequestUnitId(UUID.fromString(value));
    }

    @Override
    public String toString() {
        return value.toString();
    }
}
