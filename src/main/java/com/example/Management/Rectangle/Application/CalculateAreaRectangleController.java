package com.example.Management.Rectangle.Application;

import com.example.Management.Rectangle.Domain.Rectangle;
import com.example.Management.Rectangle.Infrastructure.Repository.RectangleRepository;
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
