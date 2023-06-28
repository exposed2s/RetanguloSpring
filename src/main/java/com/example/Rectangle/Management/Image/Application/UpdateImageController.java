package com.example.Rectangle.Management.Image.Application;

import com.example.Rectangle.Management.Domain.Rectangle;
import com.example.Rectangle.Management.Image.Domain.Image;
import com.example.Rectangle.Management.Image.Infrastructure.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateImageController {

	@Autowired
	ImageRepository repo;

	public Optional<Image> updateImage(String name, Image image) {
		Optional<Image> img = repo.findByName(name);
		if (img.isPresent()) {
			img.get().update(image);
			repo.save(img.get());
		}
		return img;
	}
}
