package com.example.restInn.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.restInn.entity.Property;

public interface PropertyDao extends MongoRepository<Property, String> {
	
	List<Property> findAllByFeatured(Boolean featured);
	
	
	List<Property> findAllByTypeOrTitleAllIgnoreCase(String type, String title);
	
	List<Property> findAllByTypeAndTitleAllIgnoreCase(String type, String title);

}
