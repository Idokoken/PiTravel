//package ndgroups.PiTravel.config;
//
//import io.swagger.v3.oas.models.Components;
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import io.swagger.v3.oas.models.security.SecurityRequirement;
//import io.swagger.v3.oas.models.security.SecurityScheme;
//import io.swagger.v3.oas.models.servers.Server;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.util.List;
//
//@Configuration
//public class OpenApiConfig {
//
//    @Bean
//    public OpenAPI myOpenAPI() {
//        Server server = new Server();
//        server.setUrl("/");
//        server.setDescription("API Server");
//
//        Info info = new Info()
//                .title("E-Commerce API")
//                .version("1.0")
//                .description("API documentation for E-Commerce Application");
//
//        // API Key security scheme
//        SecurityScheme apiKeyScheme = new SecurityScheme()
//                .type(SecurityScheme.Type.APIKEY)
//                .in(SecurityScheme.In.HEADER)
//                .name("x-api-key")
//                .description("Use ADMIN key: flutter-team-secret-8f7a7e2a5b3 " +
//                        "or SUPER_ADMIN key: flutter-team-secret-super-admin-999");
//
//        return new OpenAPI()
//                .info(info)
//                .servers(List.of(server))
//                .addSecurityItem(new SecurityRequirement().addList("ApiKeyAuth"))
//                .components(new Components()
//                        .addSecuritySchemes("ApiKeyAuth", apiKeyScheme));
//    }
//}
