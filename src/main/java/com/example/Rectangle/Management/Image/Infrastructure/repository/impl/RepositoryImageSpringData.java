package com.example.Rectangle.Management.Image.Infrastructure.repository.impl;

import com.example.Rectangle.Management.Image.Domain.Image;
import com.example.Rectangle.Management.Image.Infrastructure.repository.ImageRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.data.repository.CrudRepository;


@Profile("database")
public interface RepositoryImageSpringData extends ImageRepository, CrudRepository<Image, String> {
}
