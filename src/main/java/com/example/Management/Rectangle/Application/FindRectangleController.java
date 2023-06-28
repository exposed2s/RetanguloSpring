package com.example.Management.Rectangle.Application;

import com.example.Management.Rectangle.Domain.Rectangle;
import com.example.Management.Rectangle.Infrastructure.Repository.RectangleRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

	public List<Rectangle> findBySideGreaterThan(Integer side){
		return repo.findRectanglesBySide1GreaterThanEqual(side);
	}

	public List<Rectangle> findByArea(Double area){
		return repo.findByArea(area);
	}
}
