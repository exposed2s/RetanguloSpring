package com.example.Rectangle.Management.Infrastructure.repository.impl;

import com.example.Rectangle.Management.Domain.Rectangle;
import com.example.Rectangle.Management.Infrastructure.RectangleRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;



@Profile("database")
public interface RepositoryRepoSpringData extends RectangleRepository, CrudRepository<Rectangle, Integer> {
}
