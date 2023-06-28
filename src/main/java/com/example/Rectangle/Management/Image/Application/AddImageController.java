package com.example.Rectangle.Management.Image.Application;

import com.example.Rectangle.Management.Image.Domain.Image;
import com.example.Rectangle.Management.Image.Infrastructure.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class AddImageController {

	@Autowired
	ImageRepository repo;

	public Optional<Image> addImage(Image image) {
		return Optional.of(repo.save(image));
	}
}
