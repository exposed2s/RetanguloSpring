package com.example.Management.Rectangle.Api.Dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CreateRectangleDto {

	public Integer side1;

	public Integer side2;

	public String name;

	public CreateRectangleDto(@JsonProperty("side1") Integer side1, @JsonProperty("side2") Integer side2, @JsonProperty("name") String name) {
		this.side1 = side1;
		this.side2 = side2;
		this.name = name;
	}

	public CreateRectangleDto(){}

	public Integer getSide1() {
		return side1;
	}

	public void setSide1(Integer side1) {
		this.side1 = side1;
	}

	public Integer getSide2() {
		return side2;
	}

	public void setSide2(Integer side2) {
		this.side2 = side2;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
