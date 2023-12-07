package com.sabanciuniv.repo;

//import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sabanciuniv.model.Pet;

@Repository
public interface PetRepository extends MongoRepository<Pet, String> {
	//List<Pet> findByCategory(String catId);

}
