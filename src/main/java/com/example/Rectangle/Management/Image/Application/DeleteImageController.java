package com.example.Rectangle.Management.Image.Application;

import com.example.Rectangle.Management.Image.Domain.Image;
import com.example.Rectangle.Management.Image.Infrastructure.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class DeleteImageController {
	@Autowired
	ImageRepository repo;
	public Optional<Image> deleteImage(String name) {
		Optional<Image> rec = repo.findByName(name);
		if (rec.isPresent()) {
			repo.deleteByName(name);
		}
		return rec;
	}
}
