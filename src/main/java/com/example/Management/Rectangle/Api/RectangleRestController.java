package com.example.Management.Rectangle.Api;

import com.example.Management.Rectangle.Api.Dto.RectangleDto;
import com.example.Management.Rectangle.Application.*;
import com.example.Management.Rectangle.Api.Dto.CreateRectangleDto;
import com.example.Management.Rectangle.Domain.Rectangle;
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
	public RectangleDto addRectangle(@RequestBody CreateRectangleDto rectangleDto) {
		return addRectangleController.addRectangle(rectangleDto);
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
	public Optional<Rectangle> updateRectangle(@PathVariable("id") Integer id, @RequestBody CreateRectangleDto rectangleDto){
		Optional<Rectangle> rec = updateRectangleController.updateRectangle(id, rectangleDto);
		if (rec.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return rec;
	}

	@PatchMapping("/{id}")
	public Optional<Rectangle> patchRectangle(@PathVariable("id") Integer id, @RequestBody CreateRectangleDto rectangleDto){
		Optional<Rectangle> rec = updateRectangleController.updateRectangle(id, rectangleDto);
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
