package com.sabanciuniv.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.sabanciuniv.model.Comments;
import com.sabanciuniv.model.Pet;

@Repository
public interface CommentRepository extends MongoRepository<Comments, String> {

	
}
