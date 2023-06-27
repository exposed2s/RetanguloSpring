package com.example.Rectangle.Management.Application;

import com.example.Rectangle.Management.Domain.Rectangle;
import com.example.Rectangle.Management.Infrastructure.RectangleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class AddRectangleController {


	@Qualifier("repositoryRepoSpringData")
	@Autowired
	RectangleRepository repo;

	public Optional<Rectangle> addRectangle(Rectangle rectangle) {
		return Optional.of(repo.save(rectangle));
	}


}
