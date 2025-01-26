package com.ineuron.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerDocsConfig {

    @Bean
    public Docket createDocket() {
        return new Docket(DocumentationType.SWAGGER_2) // Specifies Swagger 2
                .select() // To specify which controllers and endpoints to document
                .apis(RequestHandlerSelectors.basePackage("com.ineuron.controller")) // Scans this package for controllers
                .paths(PathSelectors.regex("/api/tourist.*")) // Matches paths that start with /api/tourist
                .build()
                .useDefaultResponseMessages(true) // Enables default response messages for HTTP codes
                .apiInfo(getApiInfo()); // Adds custom API information
    }

    // Defines custom API information
    private ApiInfo getApiInfo() {
        Contact contact = new Contact(
                "Sagar",
                "http://www.ineuron.ai/course",
                "spgiradkar2002@gmail.com"
        );
        return new ApiInfo(
                "TouristInfo", // Title
                "Gives information about tourist activities", // Description
                "3.4 Release", // Version
                "http://www.ineuron.ai/terms", // Terms of Service URL
                contact, // Contact information
                "GNU PUBLIC", // License
                "http://apache.org/licenses/GPL-3.0", // License URL
                Collections.emptyList() // Vendor extensions
        );
    }
}
