package com.example.Management.Image.Application;

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

	public Optional<Image> createUpdateImage(String name, CreateImageDto imageDto) {
		return Optional.of(repo.save(ImageMapper.toImage(name, imageDto)));
	}
}
