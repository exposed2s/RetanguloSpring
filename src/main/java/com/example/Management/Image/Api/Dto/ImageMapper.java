package com.example.Management.Image.Api.Dto;

import com.example.Management.Image.Domain.Image;

public class ImageMapper {
	public static Image toImage(String name, CreateImageDto imageDto){
		return new Image(name, imageDto.getPath());
	}

	public static ImageDto toDto(Image image){
		return new ImageDto(image.getName(), image.getPath());
	}

	public static void update(Image image, CreateImageDto createImageDto) {
		image.setPath(createImageDto.path);
	}
}
