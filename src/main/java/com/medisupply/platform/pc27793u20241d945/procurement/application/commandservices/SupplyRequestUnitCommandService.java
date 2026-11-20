package com.medisupply.platform.pc27793u20241d945.procurement.application.commandservices;

import com.medisupply.platform.pc27793u20241d945.procurement.domain.model.aggregates.SupplyRequestUnit;
import com.medisupply.platform.pc27793u20241d945.shared.application.result.ApplicationError;
import com.medisupply.platform.pc27793u20241d945.shared.application.result.Result;
import com.medisupply.platform.pc27793u20241d945.procurement.application.commands.CreateSupplyRequestUnitCommand;

/**
 * Application port for mining equipment write use cases.
 *
 * @author Gabriel Yanac Flores
 */
public interface SupplyRequestUnitCommandService {

    Result<SupplyRequestUnit, ApplicationError> handle(CreateSupplyRequestUnitCommand command);
}
