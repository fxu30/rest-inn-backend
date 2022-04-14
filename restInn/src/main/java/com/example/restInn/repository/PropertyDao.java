package com.example.restInn.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.restInn.entity.Property;

@Repository
public interface PropertyDao extends MongoRepository<Property, String> {
	
	List<Property> findAllByFeatured(Boolean featured);
	
	
	List<Property> findAllByTypeContainingOrTitleContainingAllIgnoreCase(String type, String title);
	
	List<Property> findAllByTypeContainingAndTitleContainingAllIgnoreCase(String type, String title);

}
