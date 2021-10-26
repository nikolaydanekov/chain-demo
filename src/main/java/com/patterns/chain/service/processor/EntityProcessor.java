package com.patterns.chain.service.processor;

import com.patterns.chain.dto.EntityDto;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.ResponseEntity;

public abstract class EntityProcessor {
    public abstract ResponseEntity processEntity(ProcessorChain processorChain, EntityDto entityDto);

    //Workaround a bug of changeable chain
    public abstract EntityProcessor createNewInstance();
}
