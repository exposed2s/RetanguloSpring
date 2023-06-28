package com.example.Management.Rectangle.Domain;

import com.example.Management.Image.Domain.Image;

import javax.persistence.*;

@Entity
public class Rectangle {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "id", nullable = false)
	private Integer id;
	private Integer side1;
	private Integer side2;

	@ManyToOne
	@JoinColumn(name = "image_name")
	private Image image;


	protected Rectangle() {}

	public Rectangle(Integer side1, Integer side2, Image image){
		this.side1 = side1;
		this.side2 = side2;
		this.image = image;
	}

	public Image getImage() {
		return image;
	}

	public void setImage(Image image) {
		this.image = image;
	}

	public Rectangle(Rectangle rectangle){
		this.id = rectangle.id;
		this.side1 = rectangle.side1;
		this.side2 = rectangle.side2;
		this.image = rectangle.image;
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
		if (rectangle.image != null) {
			this.image = rectangle.image;
		}
	}

	public Double getArea(){
		return (double) (side2 * side1);
	}


}
