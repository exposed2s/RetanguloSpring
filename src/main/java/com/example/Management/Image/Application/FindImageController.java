package com.example.Management.Image.Application;


import com.example.Management.Image.Api.Dto.ImageDto;
import com.example.Management.Image.Api.Dto.ImageMapper;
import com.example.Management.Image.Domain.Image;
import com.example.Management.Image.Infrastructure.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class FindImageController {
	
	@Autowired
	ImageRepository repo;

	public List<ImageDto> findByName(String name) {
		Optional<Image> image = repo.findByName(name);
		ArrayList<ImageDto> arr = new ArrayList<>();
		image.ifPresent(value -> arr.add(ImageMapper.toDto(value)));
		return arr;
	}

	public List<ImageDto> findAll() {
		List<Image> arr = repo.findAll();
		return toDto(arr);
	}

	private List<ImageDto> toDto(List<Image> arr){
		List<ImageDto> arrDto = new ArrayList<>();
		for ( Image img: arr ) {
			arrDto.add(ImageMapper.toDto(img));
		}
		return arrDto;
	}
}
