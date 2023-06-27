package com.example.Rectangle.Management.Application;

import com.example.Rectangle.Management.Domain.Rectangle;
import com.example.Rectangle.Management.Infrastructure.RectangleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class CalculateAreaRectangleController {

	@Autowired
	RectangleRepository repo;

	public Optional<Double> calcArea(Integer id) {
		Optional<Rectangle> rec = repo.findById(id);
		return rec.map(Rectangle::getArea);
	}
}
