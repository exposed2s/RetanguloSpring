package com.example.Rectangle.Management.Image.Application;


import com.example.Rectangle.Management.Image.Domain.Image;
import com.example.Rectangle.Management.Image.Infrastructure.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class FindImageController {
	
	@Autowired
	ImageRepository repo;

	public List<Image> findByName(String name) {
		Optional<Image> image = repo.findByName(name);
		ArrayList<Image> arr = new ArrayList<>();
		image.ifPresent(arr::add);
		return arr;
	}

	public List<Image> findAll() {
		return repo.findAll();
	}
}
