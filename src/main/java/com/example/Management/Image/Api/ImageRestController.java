package com.example.Management.Image.Api;

import com.example.Management.Image.Api.Dto.ImageDto;
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
	public List<ImageDto> findImage(@RequestParam(required = false) String name) {
		if (name != null) {
			List<ImageDto> arr =  findImageController.findByName(name);
			if (arr.isEmpty()) {
				throw new ResponseStatusException(HttpStatus.NOT_FOUND);
			}
			return arr;
		} else {
			return findImageController.findAll();
		}
	}


	@PutMapping("/{name}")
	public ImageDto createOrUpdateImage(@PathVariable("name") String name, @RequestBody CreateImageDto imageDto){
		Optional<ImageDto> img = Optional.empty();

		if (name != null) {
			img = Optional.of(createUpdateImageController.createUpdateImage(name, imageDto));
		}
		if (img.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return img.get();
	}

	@DeleteMapping("/{name}")
	public Optional<ImageDto> deleteImage(@PathVariable("name") String name){
		Optional<ImageDto> rec = deleteImageController.deleteImage(name);
		if (rec.isEmpty()) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
		return rec;
	}



}
