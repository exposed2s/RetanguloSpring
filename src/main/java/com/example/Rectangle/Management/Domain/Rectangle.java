package com.example.Rectangle.Management.Domain;

import javax.persistence.*;

@Entity
public class Rectangle {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private Integer id;
	private Integer side1;
	private Integer side2;


	protected Rectangle() {}

	public Rectangle(Integer side1, Integer side2){
		this.side1 = side1;
		this.side2 = side2;
	}

	public Rectangle(Rectangle rectangle){
		this.id = rectangle.id;
		this.side1 = rectangle.side1;
		this.side2 = rectangle.side2;
	}

	public Integer getSide1() {
		return side1;
	}

	public Integer getSide2() {
		return side2;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		if (this.id != null) {
			throw new IllegalArgumentException();
		}
		this.id = id;
	}

	public void update(Rectangle rectangle){
		if (rectangle.side1 != null) {
			this.side1 = rectangle.side1;
		}
		if (rectangle.side2 != null) {
			this.side2 = rectangle.side2;
		}
	}

	public Double getArea(){
		return (double) (side2 * side1);
	}


}
