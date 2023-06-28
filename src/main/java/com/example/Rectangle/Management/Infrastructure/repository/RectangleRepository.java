package com.example.Rectangle.Management.Infrastructure.repository;

import com.example.Rectangle.Management.Domain.Rectangle;

import java.util.List;
import java.util.Optional;


public interface RectangleRepository {


	List<Rectangle> findAll();

	Optional<Rectangle> findById(Integer id);

	void deleteById(Integer id);

	Rectangle save(Rectangle rectangle);

	List<Rectangle> findRectanglesBySide1GreaterThanEqual(Integer side1);

	List<Rectangle> findByArea(Double area);
}
