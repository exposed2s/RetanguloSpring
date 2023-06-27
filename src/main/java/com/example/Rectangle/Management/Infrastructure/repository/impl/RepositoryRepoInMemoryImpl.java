package com.example.Rectangle.Management.Infrastructure.repository.impl;

import com.example.Rectangle.Management.Domain.Rectangle;
import com.example.Rectangle.Management.Infrastructure.RectangleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

@Component
public class RepositoryRepoInMemoryImpl implements RectangleRepository {

	List<Rectangle> rectangleList = new ArrayList<>();
	private static AtomicInteger counter = new AtomicInteger();


	public Rectangle createRectangle(Rectangle rectangle) {
		Rectangle copy = new Rectangle(rectangle);
		copy.setId(counter.incrementAndGet());
		return copy;
	}

	@Override
	public Optional<Rectangle> findById(Integer num) {
		for (Rectangle rectangle : rectangleList) {
			if (Objects.equals(rectangle.getId(), num)) {
				return Optional.of(rectangle);
			}
		}
		return Optional.empty();
	}

	@Override
	public void deleteById(Integer id) {
		rectangleList.remove(findById(id));
	}

	@Override
	public Rectangle save(Rectangle rectangle) {
		Optional<Rectangle> rec;
		if (rectangle.getId() != null) {
			return rectangle;
		}
		rec = Optional.of(createRectangle(rectangle));
		rectangleList.add(rec.get());
		return rec.get();
	}

	@Override
	public List<Rectangle> findAll() {
		return new ArrayList<>(rectangleList);
	}
}
