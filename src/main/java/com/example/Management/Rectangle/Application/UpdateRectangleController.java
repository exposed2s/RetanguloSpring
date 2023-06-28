package com.example.Management.Rectangle.Application;

import com.example.Management.Rectangle.Api.Dto.CreateRectangleDto;
import com.example.Management.Rectangle.Api.Dto.RectangleMapper;
import com.example.Management.Rectangle.Domain.Rectangle;
import com.example.Management.Image.Domain.Image;
import com.example.Management.Image.Infrastructure.repository.ImageRepository;
import com.example.Management.Rectangle.Infrastructure.Repository.RectangleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UpdateRectangleController {

	@Autowired
	RectangleRepository repo;

	@Autowired
	ImageRepository repoImg;

	public Optional<Rectangle> updateRectangle(Integer id, CreateRectangleDto rectangleDto) {
		Optional<Rectangle> rec = repo.findById(id);
		Optional<Image> image = Optional.empty();
		if (rectangleDto.name != null) {
			image = repoImg.findByName(rectangleDto.getName());
		}
		if (rec.isPresent()) {
			Rectangle rect = RectangleMapper.toRect(rectangleDto, image);
			rec.get().update(rect);
			repo.save(rec.get());
		}
		return rec;
	}
}
