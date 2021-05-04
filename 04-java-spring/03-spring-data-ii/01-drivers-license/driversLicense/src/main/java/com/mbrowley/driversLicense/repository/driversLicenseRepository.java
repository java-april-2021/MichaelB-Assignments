package com.mbrowley.driversLicense.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbrowley.driversLicense.model.License;

@Repository
public interface driversLicenseRepository extends CrudRepository<License, Long> {
	public List<License> findAll();
	
	public License findTopByOrderByNumberDesc();
	
	public List<License> findByStateContaining(String state);
	
	
	
	
}
