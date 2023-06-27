package com.example.Rectangle.Management.Infrastructure.repository.impl;

import com.example.Rectangle.Management.Domain.Rectangle;
import com.example.Rectangle.Management.Infrastructure.RectangleRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


@Profile("database")
public interface RepositoryRepoSpringData extends RectangleRepository, CrudRepository<Rectangle, Integer> {

	@Query("SELECT r FROM Rectangle r WHERE r.side1 > ?1 or r.side2 > ?1 ")
	List<Rectangle> findRectanglesBySide1GreaterThanEqual(Integer side1);

	@Query("SELECT r FROM Rectangle r WHERE r.side1 * r.side2 = ?1 ")
	List<Rectangle> findByArea(Integer area);


}
