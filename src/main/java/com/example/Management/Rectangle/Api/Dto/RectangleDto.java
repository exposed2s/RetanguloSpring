package com.example.Management.Rectangle.Api.Dto;

import lombok.Data;

@Data
public class RectangleDto {

	Integer id;
	Integer side1;
	Integer side2;
	String name;
	String path;

	public Double getArea(){
		return (double) (side2 * side1);
	}
}
