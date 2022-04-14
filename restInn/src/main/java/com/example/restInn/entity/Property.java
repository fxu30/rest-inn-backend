package com.example.restInn.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Properties")
public class Property {
	
	@Id
	private String id;
	private String image;
	private String type;
	private Boolean featured;
	private String title;
	private String description;
	private Double price;
	private Location location;
	private List<Amenity> amenities;
	private List<HouseRule> rules;
	// Constructors
	public Property() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Property(String id, String image, String type, Boolean featured, String title, String description,
			Double price, Location location, List<Amenity> amenities, List<HouseRule> rules) {
		super();
		this.id = id;
		this.image = image;
		this.type = type;
		this.featured = featured;
		this.title = title;
		this.description = description;
		this.price = price;
		this.location = location;
		this.amenities = amenities;
		this.rules = rules;
	}
	
	// Getter,Setter
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Boolean getFeatured() {
		return featured;
	}
	public void setFeatured(Boolean featured) {
		this.featured = featured;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Location getLocation() {
		return location;
	}
	public void setLocation(Location location) {
		this.location = location;
	}
	public List<Amenity> getAmenities() {
		return amenities;
	}
	public void setAmenities(List<Amenity> amenities) {
		this.amenities = amenities;
	}
	public List<HouseRule> getRules() {
		return rules;
	}
	public void setRules(List<HouseRule> rules) {
		this.rules = rules;
	}
	
	
}
