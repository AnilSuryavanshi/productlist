package com.bitsnbytes.product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "Product Service Rest API Documentation",
				description = "Product Service Rest APT",
				version = "v1",
				contact = @Contact(
						name = "Anil Suryavanshi",
						email = "suryavanshianil86@gmail.com"
				)
		),
		externalDocs = @ExternalDocumentation(
				description = "Sharepoint URL Product Service API",
				url = "example.com"
		)
)
@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProductApplication.class, args);
		int i = 10;

		String name = "Anil";

		int j = 20;

	}

}
