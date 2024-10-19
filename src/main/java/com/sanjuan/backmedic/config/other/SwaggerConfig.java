package com.sanjuan.backmedic.config.other;


import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.context.annotation.Configuration;

@Configuration
@OpenAPIDefinition(
        info = @Info(title = "API Documentation service medic",
                version = "1.0",
                license = @License(
                        name = "apache 2.0",
                        url = "www.apache.com"),
                contact = @Contact(
                        name = "Cbop Sarmiento Heredia Luis Alfonso",
                        email = "sarmiheredia2@gmail.com",
                        url = "www.sarmiento.com"
                )),
        servers = {
                @Server(
                        description = "DEV SERVER",
                        url = "http://localhost:8080"
                ),
                @Server(
                        description = "PROD SERVER",
                        url = "http://sarmiento.com:8080"
                )
        },
        security = @SecurityRequirement(name = "keycloak")

)
@SecurityScheme(
        name = "keycloak",
        openIdConnectUrl = "http://localhost:8085/realms/realm_ejercito/.well-known/openid-configuration",
        scheme = "bearer",
        type = SecuritySchemeType.OPENIDCONNECT,
        in = SecuritySchemeIn.HEADER

)
public class SwaggerConfig {

//    @Bean
//    public OpenAPI sgeiOpenAPI() {
//        return new OpenAPI()
//                .info(new Info().title("EJÉRCITO ECUATORIANO GESTIÓN EXPEDIENTES")
//                        .description("Servicios Rest del sistema gestion de expediente")
//                        .version("v1.0")
//                        .contact(new Contact()
//                                .name("Cbop Sarmiento H. Luis A.")
//                                .email("lasarmientoh@ejercito.mil.ec"))
//                        .license(new License().name("Apache 2.0").url("http://springdoc.org")))
//                .security(
//
//                )
//                .servers(
//
//                )
//                .externalDocs(new ExternalDocumentation()
//                        .description("End Points para el sistema de gestión de expedientes")
//                        .url("https://springshop.wiki.github.org/docs"));
//    }

}
