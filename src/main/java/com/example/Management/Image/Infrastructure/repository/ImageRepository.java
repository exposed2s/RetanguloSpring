package com.example.Management.Image.Infrastructure.repository;

import com.example.Management.Image.Domain.Image;

import java.util.List;
import java.util.Optional;

public interface ImageRepository {
	List<Image> findAll();

	Optional<Image> findByName(String name);

	void deleteById(String name);

	Image save(Image image);
}
