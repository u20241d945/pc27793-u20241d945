package com.medisupply.platform.pc27793u20241d945.procurement.interfaces.rest;

import com.medisupply.platform.pc27793u20241d945.procurement.application.commandservices.SupplyRequestUnitCommandService;
import com.medisupply.platform.pc27793u20241d945.shared.interfaces.rest.transform.ResponseEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * REST entry point for supply requests.
 *
 * @author Gabriel Yanac Flores
 */
@RestController
@RequestMapping(
        value = "/api/v1/supply-requests",
        produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(name = "Supply Requests Units", description = "Medisupply supply requests")
public class ProcurementRequestUnitsController {

    private final SupplyRequestUnitCommandService commandService;

    public ProcurementRequestUnitsController(SupplyRequestUnitCommandService commandService) {
        this.commandService = commandService;
    }

    /** Registers one unit. */
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Register a mining equipment unit",
            description = "Creates a mining equipment unit with an encrypted serial number")
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Registrado exitosamente",
                    content = @Content(schema = @Schema(implementation = ProcurementRequestUnitResource.class))),
            @ApiResponse(
                    responseCode = "400",
                    description = "Datos invalidos",
                    content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
            @ApiResponse(
                    responseCode = "409",
                    description = "Codigo duplicado",
                    content = @Content(schema = @Schema(implementation = ProblemDetail.class))),
            @ApiResponse(
                    responseCode = "500",
                    description = "Error imprevista",
                    content = @Content(schema = @Schema(implementation = ProblemDetail.class)))
    })
    public ResponseEntity<?> createEquipmentUnit(
            @Valid @RequestBody ProcurementRequestUnitResource resource) {
        var command = CreateProcurementRequestUnitCommandFromResourceAssembler
                .toCommandFromResource(resource);
        var result = commandService.handle(command);
        return ResponseEntityAssembler.toResponseEntityFromResult(
                result,
                ProcurementRequestUnitResourceFromEntityAssembler::toResourceFromEntity,
                HttpStatus.CREATED);
    }
}
