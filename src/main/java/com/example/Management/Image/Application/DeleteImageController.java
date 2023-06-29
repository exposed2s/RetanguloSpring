package com.example.Management.Image.Application;

import com.example.Management.Image.Api.Dto.ImageDto;
import com.example.Management.Image.Api.Dto.ImageMapper;
import com.example.Management.Image.Domain.Image;
import com.example.Management.Image.Infrastructure.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeleteImageController {

	@Autowired
	ImageRepository repo;
	public Optional<ImageDto> deleteImage(String name) {
		Optional<Image> rec = repo.findByName(name);
		Optional<ImageDto> imageDto = Optional.empty();
		if (rec.isPresent()) {
			imageDto = Optional.of(ImageMapper.toDto(rec.get()));
			repo.deleteById(name);
		}
		return imageDto;
	}
}
