package com.brian.dojos_and_ninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.brian.dojos_and_ninjas.models.Ninja;
import com.brian.dojos_and_ninjas.repos.NinjaRepository;

@Service
public class NinjaService {

	@Autowired // shorthand for using a constructor
	private NinjaRepository ninjaRepository;


	// returns all the books
	public List<Ninja> allNinjas() {
		return ninjaRepository.findAll();
	}

	// creates a book
	public Ninja createNinja(Ninja b) {
		return ninjaRepository.save(b);
	}

	// retrieves a language
	public Ninja findNinja(Long id) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
		if (optionalNinja.isPresent()) {
			return optionalNinja.get();
		} else {
			return null;
		}
		
	}

	// Updates a language/edit
	public Ninja updateNinja(Ninja b) {
		return ninjaRepository.save(b);

	}
	
	// Deletes a language/delete
    public void deleteNinja(Long id) {
    	ninjaRepository.deleteById(id);
    }

}
