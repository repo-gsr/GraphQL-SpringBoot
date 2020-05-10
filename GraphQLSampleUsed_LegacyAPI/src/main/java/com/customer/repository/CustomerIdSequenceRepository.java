package com.customer.repository;

@FunctionalInterface
public interface CustomerIdSequenceRepository {
	long getNextSequenceId(String key);
}