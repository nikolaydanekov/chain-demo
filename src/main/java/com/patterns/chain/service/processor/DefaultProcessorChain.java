package com.patterns.chain.service.processor;

import com.patterns.chain.dto.EntityDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public class DefaultProcessorChain implements ProcessorChain{
    private Integer index = -1;
    private final List<EntityProcessor> entityProcessors;

    public DefaultProcessorChain(List<EntityProcessor> entityProcessors){
        this.entityProcessors = entityProcessors;
    }
    @Override
    public ResponseEntity process(EntityDto entityDto) {
        index++;
        if(index < entityProcessors.size()){
            return entityProcessors.get(index).processEntity(this, entityDto);
        }
        return ResponseEntity.ok(entityDto);
    }
}
