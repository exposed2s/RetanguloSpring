package com.example.Rectangle.Management.Application;

import com.example.Rectangle.Management.Domain.Rectangle;
import com.example.Rectangle.Management.Infrastructure.RectangleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class FindRectangleController {

	@Autowired
	RectangleRepository repo;

	public List<Rectangle> findAll(){
		return repo.findAll();
	}

	public Optional<Rectangle> findById(int id) {
		return repo.findById(id);
	}
}
