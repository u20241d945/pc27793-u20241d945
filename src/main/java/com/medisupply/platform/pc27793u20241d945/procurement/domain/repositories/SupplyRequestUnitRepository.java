package com.medisupply.platform.pc27793u20241d945.procurement.domain.repositories;

import com.medisupply.platform.pc27793u20241d945.procurement.domain.model.aggregates.SupplyRequestUnit;


public interface SupplyRequestUnitRepository {

    SupplyRequestUnit save(SupplyRequestUnit unit);

    boolean existsBySerialNumberAndAssigned(String serialNumber, String assigned);
}
