package com.medisupply.platform.pc27793u20241d945.procurement.domain.model.aggregates;

import com.medisupply.platform.pc27793u20241d945.procurement.domain.model.valueobjects.MedProcurementRequestUnitId;
import com.medisupply.platform.pc27793u20241d945.shared.domain.model.valueobjects.UrgencyLevel;

import java.time.Instant;


public final class SupplyRequestUnit {

    private final Long id;
    private final String requestCode;
    private final String facilityId;
    private final String fulfillmentPeriodStartDate;
    private final String fulfillmentPeriodEndDate;
    private final int supplyBatchQuantity;
    private final String supplyBatchUnit;
    private final UrgencyLevel urgencyLevel;
    private final String status;


    private final Instant createdAt;
    private final Instant updatedAt;

    public Long getId() {
        return id;
    }

    public String getRequestCode() {
        return requestCode;
    }

    public String getFacilityId() {
        return facilityId;
    }

    public String getFulfillmentPeriodStartDate() {
        return fulfillmentPeriodStartDate;
    }

    public String getFulfillmentPeriodEndDate() {
        return fulfillmentPeriodEndDate;
    }

    public int getSupplyBatchQuantity() {
        return supplyBatchQuantity;
    }

    public String getSupplyBatchUnit() {
        return supplyBatchUnit;
    }

    public UrgencyLevel getUrgencyLevel() {
        return urgencyLevel;
    }

    public String getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    private SupplyRequestUnit(
            Long id,
            MedProcurementRequestUnitId requestUnitId,
            String requestCode,
            String facilityId,
            String fulfillmentPeriodStartDate,
            String fulfillmentPeriodEndDate,
            int supplyBatchQuantity,
            String supplyBatchUnit,
            UrgencyLevel urgencyLevel,
            String status,

            Instant createdAt,
            Instant updatedAt) {
        this.id = id;
        this.requestCode=requestCode;
        this.facilityId=facilityId;
        this.fulfillmentPeriodStartDate=fulfillmentPeriodStartDate;
        this.fulfillmentPeriodEndDate=fulfillmentPeriodEndDate;
        this.supplyBatchQuantity=supplyBatchQuantity;
        this.urgencyLevel=urgencyLevel;
        this.supplyBatchUnit=supplyBatchUnit;
        this.status=status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    /** Creates a new aggregate and generates its business identifier. */
    public static SupplyRequestUnit create(
            String requestCode,
            String facilityId,
            String fulfillmentPeriodStartDate,
            String fulfillmentPeriodEndDate,
            int supplyBatchQuantity,
            String supplyBatchUnit,
            UrgencyLevel urgencyLevel,
            String status) {
        return new SupplyRequestUnit(
                null,
                MedProcurementRequestUnitId.generate(),
                requestCode,
                facilityId,
                fulfillmentPeriodStartDate,
                fulfillmentPeriodEndDate,
                supplyBatchQuantity,
                supplyBatchUnit,
                urgencyLevel,
                status,
                null,
                null);
    }


    private static String requireText(String value, String fieldName) {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException(fieldName + " is required");
        }
        return value.trim();
    }


}
