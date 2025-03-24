package com.toyblog.repository;

import com.toyblog.entity.Image;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ImageRepository {
    Image save(Image image);

    Image findById(UUID id);

    Image findByName(String name);

    void delete(UUID id);
}
