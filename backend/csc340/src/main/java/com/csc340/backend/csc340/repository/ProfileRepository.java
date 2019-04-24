package com.csc340.backend.csc340.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.csc340.backend.csc340.models.Profile;

/**
 * Created by rajeevkumarsingh on 27/06/17.
 */

@Repository
public interface ProfileRepository extends JpaRepository<Profile, Long> {
	Profile findByUsername(String username);
}
