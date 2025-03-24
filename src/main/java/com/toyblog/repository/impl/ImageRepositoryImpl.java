package com.toyblog.repository.impl;

import com.toyblog.entity.Image;
import com.toyblog.exception.ImageNotFoundException;
import com.toyblog.repository.ImageRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ImageRepositoryImpl implements ImageRepository {
    List<Image> imageList = new ArrayList<>();

    @Override
    public Image save(Image image) {
        imageList.add(image);
        return image;
    }

    @Override
    public Image findById(UUID id) {
        return imageList.stream().filter(i -> i.getId().equals(id)).findFirst().orElseThrow(() -> new ImageNotFoundException("이미지를 찾을 수 없습니다."));
    }

    @Override
    public Image findByName(String name) {
        return imageList.stream().filter(i -> i.getOriginalName().equals(name)).findFirst().orElseThrow(() -> new ImageNotFoundException("이미지를 찾을 수 없습니다."));
    }

    @Override
    public void delete(UUID id) {
        Image target = findById(id);
        imageList.remove(target);
    }
}
