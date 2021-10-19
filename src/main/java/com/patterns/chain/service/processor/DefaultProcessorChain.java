package com.patterns.chain.service.processor;

import com.patterns.chain.dto.EntityDto;
import org.springframework.http.ResponseEntity;

import java.util.Collection;
import java.util.Iterator;

public class DefaultProcessorChain implements ProcessorChain{
    private final Iterator<EntityProcessor> entityProcessorIterator;

    public DefaultProcessorChain(Collection<EntityProcessor> entityProcessors){
        entityProcessorIterator = entityProcessors.iterator();
    }
    @Override
    public ResponseEntity process(EntityDto entityDto) {
        if(entityProcessorIterator.hasNext()){
            return entityProcessorIterator.next().processEntity(this, entityDto);
        }
        return ResponseEntity.ok(entityDto);
    }
}
