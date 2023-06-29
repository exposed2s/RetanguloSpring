package com.example.Management.Rectangle.Api.Dto;

import com.example.Management.Rectangle.Domain.Rectangle;
import com.example.Management.Image.Domain.Image;

import java.util.Optional;

public class RectangleMapper {

	public static Rectangle toRect(CreateRectangleDto rectangleDto){
		return new Rectangle(rectangleDto.side1, rectangleDto.side2, null);
	}
	public static Rectangle toRect(CreateRectangleDto rectangleDto, Optional<Image> image) {
		return image.map(value -> new Rectangle(rectangleDto.side1, rectangleDto.side2, value)).orElseGet(() -> toRect(rectangleDto));
	}

	public static RectangleDto toDto(Rectangle rectangle) {
		RectangleDto dto = new RectangleDto();
		if (rectangle.getImage() != null) {
			dto.setName(rectangle.getImage().getName());
			dto.setPath(rectangle.getImage().getPath());
		}
		dto.setId(rectangle.getId());
		dto.setSide1(rectangle.getSide1());
		dto.setSide2(rectangle.getSide2());
		return dto;
	}
}
