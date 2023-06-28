package com.example.Management.Rectangle.Infrastructure.Repository;

import com.example.Management.Rectangle.Domain.Rectangle;

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
