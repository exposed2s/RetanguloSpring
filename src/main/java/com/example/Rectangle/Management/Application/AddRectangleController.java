package com.example.Rectangle.Management.Application;

import com.example.Rectangle.Management.Domain.Rectangle;
import com.example.Rectangle.Management.Infrastructure.RectangleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class AddRectangleController {

	@Autowired
	RectangleRepository repo;

	public Optional<Rectangle> addRectangle(Rectangle rectangle) {
		return repo.save(rectangle);
	}


}
