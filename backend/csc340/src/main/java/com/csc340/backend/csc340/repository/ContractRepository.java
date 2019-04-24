package com.csc340.backend.csc340.repository;

import java.util.Optional;

import com.csc340.backend.csc340.Contract;

public interface ContractRepository {
	Optional<Contract> findById(Long id);
}
