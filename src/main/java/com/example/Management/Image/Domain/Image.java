package com.example.Management.Image.Domain;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Image {

//	@Id
//	@GeneratedValue(strategy = GenerationType.SEQUENCE)
//	@Column(name = "id", nullable = false)
//	private Long id;

	@Id
	private String name;

	private String path;

//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}

	public Image(){}

	public Image(@JsonProperty("name") String name, @JsonProperty("path") String path){
		this.name = name;
		this.path = path;
	}

	public void update(Image image){
		if (image.name != null) {
			this.name = image.name;
		}
		if (image.path != null) {
			this.path = image.path;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}


}