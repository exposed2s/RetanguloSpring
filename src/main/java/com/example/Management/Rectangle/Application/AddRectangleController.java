package com.example.Management.Rectangle.Application;

import com.example.Management.Rectangle.Api.Dto.CreateRectangleDto;
import com.example.Management.Rectangle.Api.Dto.RectangleDto;
import com.example.Management.Rectangle.Api.Dto.RectangleMapper;
import com.example.Management.Rectangle.Domain.Rectangle;
import com.example.Management.Image.Domain.Image;
import com.example.Management.Image.Infrastructure.repository.ImageRepository;
import com.example.Management.Rectangle.Infrastructure.Repository.RectangleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;


@Component
public class AddRectangleController {


	@Autowired
	RectangleRepository RectRepo;

	@Autowired
	ImageRepository imgRepo;

	public RectangleDto addRectangle(CreateRectangleDto rectangleDto) {
		Optional<Image> image = Optional.empty();
		Rectangle rectangle;
		if (rectangleDto.name != null) {
			image = imgRepo.findByName(rectangleDto.getName());
		}
		rectangle = RectangleMapper.toRect(rectangleDto, image);
		return RectangleMapper.toDto(RectRepo.save(rectangle));

	}


}
