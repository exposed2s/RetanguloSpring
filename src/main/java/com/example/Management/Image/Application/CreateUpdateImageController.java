package com.example.Management.Image.Application;

import com.example.Management.Image.Api.Dto.ImageDto;
import com.example.Management.Image.Domain.Image;
import com.example.Management.Image.Infrastructure.repository.ImageRepository;
import com.example.Management.Image.Api.Dto.CreateImageDto;
import com.example.Management.Image.Api.Dto.ImageMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class CreateUpdateImageController {

	@Autowired
	ImageRepository repo;

	public ImageDto createUpdateImage(String name, CreateImageDto createImageDto) {
		Optional<Image> img = repo.findByName(name);
		Image image;
		if (img.isPresent()) {
			image = img.get();
			ImageMapper.update(image, createImageDto);
		} else {
			image = ImageMapper.toImage(name, createImageDto);
		}
		return ImageMapper.toDto(repo.save(image));
	}


}
