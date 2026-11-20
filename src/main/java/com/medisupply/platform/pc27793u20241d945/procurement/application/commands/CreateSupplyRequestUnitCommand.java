package com.medisupply.platform.pc27793u20241d945.procurement.application.commands;


public record CreateSupplyRequestUnitCommand(
        String requestCode,
        String facilityId,
        String fulfillmentPeriodStartDate,
        String fulfillmentPeriodEndDate,
        int supplyBatchQuantity,
        String supplyBatchUnit,
        int urgencyLevel,
        String status,
        String requestNotes
) {
}
