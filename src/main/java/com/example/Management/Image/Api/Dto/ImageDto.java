package com.example.Management.Image.Api.Dto;

import lombok.Data;

@Data
public class ImageDto {
	String name;
	String path;

	public ImageDto(String name, String path){
		this.name = name;
		this.path = path;
	}

}
