package br.com.fabio.dnareader.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.fabio.dnareader.controller")).build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
        .title("DNA Reader")
        .description("Technical test for a back-end developer job on Mercado Livre. " +
                     "The purpose of the REST API is to implement a service for verifying a DNA sequence." +
                     "The API checks whether the DNA is from an ape or a human." +
                     "Is also returned the ratio of apes to the human population.")
        .version("1.0.0")
        .contact(new Contact("Fábio Henrique Gonçalves Damas", "https://fabiodamas.github.io", "fabio.damas@gmail.com"))
        .build();
    }
}