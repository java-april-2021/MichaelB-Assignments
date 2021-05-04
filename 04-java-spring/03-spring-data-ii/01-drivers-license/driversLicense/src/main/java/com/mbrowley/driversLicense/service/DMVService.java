package com.mbrowley.driversLicense.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mbrowley.driversLicense.model.License;
import com.mbrowley.driversLicense.model.Person;
import com.mbrowley.driversLicense.repository.PersonRepository;
import com.mbrowley.driversLicense.repository.driversLicenseRepository;

@Service
public class DMVService {
	
	private final PersonRepository pRepo;
	private final driversLicenseRepository dRepo;
	
	public DMVService(PersonRepository pRepo, driversLicenseRepository dRepo) {
		this.pRepo = pRepo;
		this.dRepo = dRepo;
	}
	
	//find person by id
	public Person getPerson(Long id) {
		return pRepo.findById(id).orElse(null);
	}
	//find all people
	public List<Person> allPeople(){
		return pRepo.findAll();
	}
	//people riding dirty
	public List<Person> getUnlicensePeople(){
		return pRepo.findByLicenseIdIsNull();
	}
	//create and updaes a person 
	public Person savePerson(Person person) {
		return pRepo.save(person);
	}
	//created and updates license
	public License saveLicense(License lic) {
		lic.setNumber(this.generateLicenseNumber());
		return dRepo.save(lic);
	}
	//id
	public Integer generateLicenseNumber() {
		License lic = dRepo.findTopByOrderByNumberDesc();
		if(lic==null) {
			return 1;
		}else {
			Integer nxtNum = lic.getNumber();
			nxtNum++;
			return nxtNum;
		}
	}
	//finds a person
	public Person findPerson(Long id) {
		return pRepo.findById(id).orElse(null);
	}
	
	
	
}
