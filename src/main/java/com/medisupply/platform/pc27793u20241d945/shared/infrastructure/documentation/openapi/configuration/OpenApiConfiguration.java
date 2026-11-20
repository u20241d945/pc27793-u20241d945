package com.medisupply.platform.pc27793u20241d945.shared.infrastructure.documentation.openapi.configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Provides the public OpenAPI metadata displayed by Swagger UI.
 *
 * @author Gabriel Yanac Flores
 */
@Configuration
public class OpenApiConfiguration {

    @Bean
    public OpenAPI medisupplyProcurementOpenApi() {
        return new OpenAPI().info(new Info()
                .title("Medisupply Procurement API")
                .description("Registers medisupply procurements units")
                .version("v1"));
    }
}
