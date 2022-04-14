package com.example.restInn.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.restInn.entity.Property;
import com.example.restInn.repository.PropertyDao;

@Service
public class PropertyService {
	@Autowired
	PropertyDao propertyDao;

	// Get all properties
	public List<Property> getAllProperties() {
		return propertyDao.findAll();
	}

	// Get all best seller properties
	public List<Property> getAllFeaturedProperties() {
		return propertyDao.findAllByFeatured(true);
	}
	
	// Get properties by both title and type
	public List<Property> getAllPropertyByTypeAndTitle(String type, String title){
		return propertyDao.findAllByTypeContainingAndTitleContainingAllIgnoreCase(type, title);
	}
	
	// Get properties by title
	public List<Property> getAllPropertyByTitle(String title){
		return propertyDao.findAllByTypeContainingOrTitleContainingAllIgnoreCase(null, title);
	}
	
	// Get properties by type
	public List<Property> getAllPropertyByType(String type){
		return propertyDao.findAllByTypeContainingOrTitleContainingAllIgnoreCase(type, null);
	}
	
	
	// Get a property by Id
	public Property getProperty(String propertyId) {
		Optional<Property> property =propertyDao.findById(propertyId);
		if(property.isPresent())
		{
			return property.get();
		}
		else
		{
			return null;
		}
	}

	// Create a new property
	public Property createProperty(Property property) {
		return propertyDao.save(property);
	}

	// Update a property
	public Property updateProperty(Property property) {
		return propertyDao.save(property);
	}

	// Delete a property by id
	public void deleteProperty(String propertyId) {
		propertyDao.deleteById(propertyId);
		
	}


}
