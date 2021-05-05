package com.mbrowley.DojosAndNinjas.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mbrowley.DojosAndNinjas.model.Dojo;
import com.mbrowley.DojosAndNinjas.model.Ninja;
import com.mbrowley.DojosAndNinjas.repository.dojoRepository;
import com.mbrowley.DojosAndNinjas.repository.ninjaRepository;

@Service
public class DNService {
	
	private final ninjaRepository nRepo;
	private final dojoRepository dRepo;
	
	public DNService(ninjaRepository nRepo, dojoRepository dRepo) {
		this.nRepo = nRepo;
		this.dRepo = dRepo;
	}
	
	//find all Dojos
	public List<Dojo> findDojos(){
		return dRepo.findAll();
	}
	
	//find all Ninja
	public List<Ninja> findNinjas(){
		return nRepo.findAll();
	}
	
	//find a single Dojo
	public Dojo getDojo(Long id) {
		return dRepo.findById(id).orElse(null);
	}
	
	//find a single Ninja
	public Ninja getNinja(Long id) {
		return nRepo.findById(id).orElse(null);
	}
	
	//save and update ninja
	public Ninja saveNinja(Ninja ninja) {
		return nRepo.save(ninja);
	}
	
	//save and update Dojo
	public Dojo saveDojo(Dojo dojo) {
		return dRepo.save(dojo);
	}
	
}
