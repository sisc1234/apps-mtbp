package com.apps.mtbp.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class BeansConfig {

	@Bean
	public OpenAPI customOpenAPI(@Value("${application-description}") String appDesciption,
			@Value("${application-version}") String appVersion) {

		List<Server> servers = new ArrayList<Server>();

		servers.add(new Server().description("Mtbp Theater Local Server").url("http://localhost:8080/"));

		return new OpenAPI().servers(servers)
				.info(new Info().title("Mtbp Theater API Specification").version(appVersion)
						.description(appDesciption).termsOfService("http://swagger.io/terms/")
						.license(new License().name("Apache 2.0").url("http://springdoc.org")));
	}

}
