package com.patterns.chain.service.processor;

import com.patterns.chain.dto.EntityDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

public abstract class EntityProcessor {
    @Getter
    @Setter
    public EntityProcessor nextProcessor;

    public abstract ResponseEntity processEntity(EntityDto entityDto);

    public abstract EntityProcessor createNewInstance();
}
