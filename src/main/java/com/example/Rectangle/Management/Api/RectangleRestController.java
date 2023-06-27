package com.example.Rectangle.Management.Api;

import com.example.Rectangle.Management.Application.*;
import com.example.Rectangle.Management.Domain.Rectangle;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@RequestMapping("/domain/rectangle")
@RestController
public class RectangleRestController {
	private static AtomicLong counter = new AtomicLong();
	@Autowired
	FindRectangleController finderController;

	@Autowired
	CalculateAreaRectangleController calculateAreaRectangleController;

	@Autowired
	DeleteRectangleController deleteRectangleController;

	@Autowired
	UpdateRectangleController updateRectangleController;

	@Autowired
	AddRectangleController addRectangleController;

	@GetMapping
	public List<Rectangle> findRectangle(@RequestParam(required = false) Integer length, @RequestParam(required = false) Double area) {
		if (area != null) {
			return finderController.findByArea(area);
		} else if (length != null) {
			return finderController.findBySideGreaterThan(length);
		} else {
			return finderController.findAll();
		}
	}

	@PostMapping
	public Optional<Rectangle> addRectangle(@RequestBody Rectangle rectangle) {
		return addRectangleController.addRectangle(rectangle);
	}

	@GetMapping("/{id}")
	public Optional<Rectangle> findById(@PathVariable("id")Integer id) throws JsonProcessingException {
		Optional<Rectangle> rec =  finderController.findById(id);
		if (rec.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return rec;
	}

	@PutMapping("/{id}")
	public Optional<Rectangle> updateRectangle(@PathVariable("id") Integer id, @RequestBody Rectangle rectangle){
		Optional<Rectangle> rec = updateRectangleController.updateRectangle(id, rectangle);
		if (rec.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return rec;
	}

	@PatchMapping("/{id}")
	public Optional<Rectangle> patchRectangle(@PathVariable("id") Integer id, @RequestBody Rectangle rectangle){
		Optional<Rectangle> rec = updateRectangleController.updateRectangle(id, rectangle);
		if (rec.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return rec;
	}

	@DeleteMapping("/{id}")
	public Optional<Rectangle> deleteRectangle(@PathVariable("id") Integer id){
		Optional<Rectangle> rec = deleteRectangleController.deleteRectangle(id);
		if (rec.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return rec;
	}

	@GetMapping("/{id}/area")
	public Optional<Double> calcArea(@PathVariable("id") Integer id){
		Optional<Double> area = calculateAreaRectangleController.calcArea(id);
		if (area.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return area;
	}

}
