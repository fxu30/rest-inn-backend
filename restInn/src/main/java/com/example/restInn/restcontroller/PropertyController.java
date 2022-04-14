package com.example.restInn.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.restInn.entity.Property;
import com.example.restInn.service.PropertyService;

@RestController
public class PropertyController {
	
	@Autowired
	PropertyService propertyService;
	
	@GetMapping("/Properties")
	public List<Property> getAllProperties(@RequestParam (name="featured",required=false,defaultValue="false") Boolean featured){
		if (featured) {
			return propertyService.getAllFeaturedProperties();
		} else {
			return propertyService.getAllProperties();
		}
	}
	
	@GetMapping("/Properties/search")
	public List<Property> getAllSearchProperties(@RequestParam(name="type", required=false) String type, @RequestParam(name="title",required=false) String title){
		if (type != null && title != null) {
			return propertyService.getAllPropertyByTypeAndTitle(type, title);
		} else if (type != null) {
			return propertyService.getAllPropertyByType(type);
		} else if (title != null) {
			return propertyService.getAllPropertyByTitle(title);
		} else {
			return propertyService.getAllProperties();
		}
	}
	
	@GetMapping("/Properties/{propertyId}")
	public ResponseEntity<Property> getProperty(@PathVariable String propertyId){
		Property p = propertyService.getProperty(propertyId);
		if (p != null) {
			return new ResponseEntity<Property>(p, HttpStatus.OK);
			
		} else {
			return new ResponseEntity<Property>(new Property(), HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/Properties")
	public ResponseEntity<Property> addProperty(@RequestBody Property property){
		Property p = propertyService.createProperty(property);
		return new ResponseEntity<Property>(p, HttpStatus.CREATED);
	}
	
	@PutMapping("/Properties/{propertyId}")
	public ResponseEntity<Property> updateProperty(@RequestBody Property property, @PathVariable String propertyId){
		Property existProperty = propertyService.getProperty(propertyId);
		
		if (existProperty != null) {
			property.setId(propertyId);
			Property p = propertyService.updateProperty(property);
			return new ResponseEntity<Property>(p, HttpStatus.OK);
			
		}else {
			// If non-existing property, will create one with new id
			Property p = propertyService.createProperty(property);
			return new ResponseEntity<Property>(p, HttpStatus.CREATED);
		}
	}
	
	@DeleteMapping("/Properties/{propertyId}")
	public ResponseEntity<String> deleteProperty(@PathVariable String propertyId){
		Property p = propertyService.getProperty(propertyId);
		if (p != null) {
			propertyService.deleteProperty(propertyId);
			return new ResponseEntity<String>("Property deleted: "+propertyId, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>("Property not available to delete: "+propertyId, HttpStatus.NOT_FOUND);
		}
	}
	

}
