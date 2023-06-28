package com.example.Rectangle.Management.Image.Infrastructure.repository;

import com.example.Rectangle.Management.Image.Domain.Image;

import java.util.List;
import java.util.Optional;

public interface ImageRepository {
	List<Image> findAll();

	Optional<Image> findByName(String name);

	void deleteByName(String name);

	Image save(Image image);
}
