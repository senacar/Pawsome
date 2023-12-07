package com.sabanciuniv.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Pet {
	@Id private String id;
	
	private String title;
	private String breed;
	private String description;
	private String imgPath;
	
	public Pet() {
		
	}
	
	public Pet(String id, String title,String breed, String description, String imgPath) {
		super();
		this.id= id;
		this.title= title;
		this.breed= breed;
		this.description= description;
		this.imgPath= imgPath;
				
	}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id= id;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title= title;
	}
	public String getBreed() {
		return breed;
	}
	
	public void setBreed(String breed) {
		this.breed= breed;
	}
	
	public String getDesc() {
		return description;
	}
	
	public void setDesc(String description) {
		this.description= description;
	}
	
	public String getImgPath() {
		return imgPath;
	}
	
	public void setImgPath(String imgPath) {
		this.imgPath= imgPath;
	}
	
	@Override
	public String toString() {
		return "Pet [id=" + id + ", title=" + title+ ", breed="+ breed +", description="+ description+ "imgPath="+ imgPath+"]";
	}


}
