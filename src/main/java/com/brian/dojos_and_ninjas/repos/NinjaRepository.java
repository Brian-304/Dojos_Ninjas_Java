package com.brian.dojos_and_ninjas.repos;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.brian.dojos_and_ninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository <Ninja, Long>{
	  // this method retrieves all the books from the database
	List<Ninja> findAll();

}
