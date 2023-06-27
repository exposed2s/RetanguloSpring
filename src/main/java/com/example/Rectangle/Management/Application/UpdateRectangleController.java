package com.example.Rectangle.Management.Application;

import com.example.Rectangle.Management.Domain.Rectangle;
import com.example.Rectangle.Management.Infrastructure.RectangleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateRectangleController {

	@Qualifier("repositoryRepoSpringData")
	@Autowired
	RectangleRepository repo;

	public Optional<Rectangle> updateRectangle(int id, Rectangle rectangle) {
		Optional<Rectangle> rec = repo.findById(id);
		if (rec.isPresent()) {
			rec.get().update(rectangle);
			repo.save(rec.get());
		}
		return rec;
	}
}
