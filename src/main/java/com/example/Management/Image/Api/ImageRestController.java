package com.example.Management.Image.Api;

import com.example.Management.Image.Application.CreateUpdateImageController;
import com.example.Management.Image.Application.DeleteImageController;
import com.example.Management.Image.Application.FindImageController;
import com.example.Management.Image.Domain.Image;
import com.example.Management.Image.Api.Dto.CreateImageDto;
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
	DeleteImageController deleteImageController;

	@Autowired
	CreateUpdateImageController createUpdateImageController;

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
	public Optional<Image> updateImage(@PathVariable("name") String name, @RequestBody CreateImageDto imageDto){
		Optional<Image> rec = createUpdateImageController.createUpdateImage(name, imageDto);
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



}
