package com.brian.dojos_and_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.dojos_and_ninjas.models.Dojo;
import com.brian.dojos_and_ninjas.repos.DojoRepository;



@Service
public class DojoService {
	
	@Autowired // shorthand for using a constructor
	private DojoRepository dojoRepository;

	// returns all the dojos
	public List<Dojo> allDojos() {
		return dojoRepository.findAll();
	}

	// creates a dojo
	public Dojo createDojo(Dojo b) {
		return dojoRepository.save(b);
	}

	// retrieves a dojo
	public Dojo findDojo(Long id) {
		Optional<Dojo> optionalDojo = dojoRepository.findById(id);
		if (optionalDojo.isPresent()) {
			return optionalDojo.get();
		} else {
			return null;
		}
		
	}

	// Updates a language/edit
	public Dojo updateDojo(Dojo b) {
		return dojoRepository.save(b);

	}
	
	// Deletes a language/delete
    public void deleteDojo(Long id) {
    	dojoRepository.deleteById(id);
    }

}
