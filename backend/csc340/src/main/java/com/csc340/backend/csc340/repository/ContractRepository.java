package com.csc340.backend.csc340.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csc340.backend.csc340.Contract;
import com.csc340.backend.csc340.models.Profile;

@Repository
public interface ContractRepository extends JpaRepository<Contract, Long> {
	Contract findById(String username);
	Contract findByProposer(Profile Proposer);
}
