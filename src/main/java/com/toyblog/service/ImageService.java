package com.toyblog.service;

import com.toyblog.dto.CreateImageRequestDTO;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public interface ImageService {
    UUID save(CreateImageRequestDTO requestDTO);
}
