package com.toyblog.service.impl;

import com.toyblog.dto.CreateImageRequestDTO;
import com.toyblog.entity.Image;
import com.toyblog.repository.ImageRepository;
import com.toyblog.service.ImageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final ImageRepository imageRepository;

    @Override
    public UUID save(CreateImageRequestDTO requestDTO) {
        Image image = new Image(requestDTO.originalName(), requestDTO.extension(), (long) requestDTO.bytes().length, requestDTO.bytes());
        imageRepository.save(image);
        return image.getId();
    }
}
