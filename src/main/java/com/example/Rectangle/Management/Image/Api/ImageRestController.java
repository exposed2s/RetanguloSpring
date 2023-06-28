package com.example.Rectangle.Management.Image.Api;

import com.example.Rectangle.Management.Image.Application.AddImageController;
import com.example.Rectangle.Management.Image.Application.DeleteImageController;
import com.example.Rectangle.Management.Image.Application.FindImageController;
import com.example.Rectangle.Management.Image.Application.UpdateImageController;
import com.example.Rectangle.Management.Image.Domain.Image;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RequestMapping("/domain/image")
@RestController
public class ImageRestController {

	@Autowired
	FindImageController findImageController;

	@Autowired
	AddImageController addImageController;

	@Autowired
	DeleteImageController deleteImageController;

	@Autowired
	UpdateImageController updateImageController;

	@GetMapping
	public List<Image> findImage(@RequestParam(required = false) String name) {
		if (name != null) {
			List<Image> arr =  findImageController.findByName(name);
			if (arr.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
			return arr;
		} else {
			return findImageController.findAll();
		}
	}


	@PutMapping("/{name}")
	public Optional<Image> updateImage(@PathVariable("name") String name, @RequestBody Image image){
		Optional<Image> rec = updateImageController.updateImage(name, image);
		if (rec.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return rec;
	}

	@DeleteMapping("/{name}")
	public Optional<Image> deleteImage(@PathVariable("name") String name){
		Optional<Image> rec = deleteImageController.deleteImage(name);
		if (rec.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return rec;
	}

	@PostMapping
	public Optional<Image> addImage(@RequestBody Image image) {
		return addImageController.addImage(image);
	}


}
