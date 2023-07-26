package com.library;


import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration

public class SwaggerConfiguration {

    @Bean
    public OpenAPI libraryOpenAPI(){
        String schemeName = "bearerAuth";
        Info info = new Info().title("library API Documentation")
                .description("Contoh Open API Untuk BC24")
                .version("v 1.0.0")
                .license(new License().name("Apache 2.0")
                        .url("http://springdoc.ord"));

        var externalDocumentation = new ExternalDocumentation()
                .description("library Documentation")
                .url("/library");

        var requirement = new SecurityRequirement().addList(schemeName);
        var scheme = new SecurityScheme().name(schemeName)
                .type(SecurityScheme.Type.HTTP).
                scheme("bearer")
                .bearerFormat("JWT");

        var components = new Components().addSecuritySchemes(schemeName,scheme);

        OpenAPI openAPI = new OpenAPI()
                .info(info)
                .externalDocs(externalDocumentation)
                .addSecurityItem(requirement).
                components(components);

        return openAPI;
    }

}
