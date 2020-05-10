package com.graphql.repository;

@FunctionalInterface
public interface CustomerIdSequenceRepository {
	long getNextSequenceId(String key);
}