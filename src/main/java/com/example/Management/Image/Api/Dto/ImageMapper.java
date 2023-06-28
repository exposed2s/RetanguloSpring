package com.example.Management.Image.Api.Dto;

import com.example.Management.Image.Domain.Image;

public class ImageMapper {
	public static Image toImage(String name, CreateImageDto imageDto){
		if (imageDto.getName() != null) {
			return new Image(imageDto.getName(), imageDto.getPath());
		}
		return new Image(name, imageDto.getPath());
	}
}
