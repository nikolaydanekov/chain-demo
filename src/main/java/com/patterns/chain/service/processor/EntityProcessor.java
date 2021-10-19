package com.patterns.chain.service.processor;

import com.patterns.chain.dto.EntityDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

public abstract class EntityProcessor {
    public abstract ResponseEntity processEntity(ProcessorChain processorChain, EntityDto entityDto);

    public abstract EntityProcessor createNewInstance();
}
