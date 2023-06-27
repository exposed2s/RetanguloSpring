package com.example.Rectangle.Management.Infrastructure;

import com.example.Rectangle.Management.Domain.Rectangle;

import java.util.List;
import java.util.Optional;


public interface RectangleRepository {


	List<Rectangle> findAll();

	Optional<Rectangle> findById(Integer id);

	void deleteRectangle(Integer id);

	Optional<Rectangle> save(Rectangle rectangle);
}
