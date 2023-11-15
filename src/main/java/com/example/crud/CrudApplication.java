package com.example.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.LinkedHashMap;
import java.util.Map;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}

	@Bean
	public graphql.schema.GraphQLScalarType extendedScalarLong() {
		return graphql.scalars.ExtendedScalars.GraphQLLong;
	}

	@Bean
	public CorsFilter curionCorsConfiguration() {
		CorsConfiguration corsConfiguration = new CorsConfiguration();
		corsConfiguration.addAllowedOriginPattern("*");
		corsConfiguration.addAllowedHeader("*");
		corsConfiguration.addAllowedMethod("*");
		corsConfiguration.addExposedHeader("ExposedHeaderName");

		Map<String, CorsConfiguration> corsConfigurations = new LinkedHashMap<>(1);
		corsConfigurations.put("/graphql/**", corsConfiguration);

		UrlBasedCorsConfigurationSource configurationSource = new UrlBasedCorsConfigurationSource();
		configurationSource.setCorsConfigurations(corsConfigurations);
		configurationSource.setAllowInitLookupPath(true);

		return new CorsFilter(configurationSource);
	}
}
