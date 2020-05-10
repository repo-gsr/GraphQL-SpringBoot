package com.graphql;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;

@Configuration
public class CustomeScalarTypeConfig {
	@Bean
	public GraphQLScalarType dateType() {
		return ExtendedScalars.Date;
	}
}
