package com.patterns.chain.service;

import com.patterns.chain.dto.EntityDto;
import org.springframework.http.ResponseEntity;

public interface EntityService {
    ResponseEntity processEntity(EntityDto entityDto);
}
