package com.patterns.chain.service.processor;

import com.patterns.chain.dto.EntityDto;
import org.springframework.http.ResponseEntity;

public class BasicProcessor extends EntityProcessor{
    @Override
    public ResponseEntity processEntity(EntityDto entityDto) {
        if(nextProcessor != null){
            return nextProcessor.processEntity(entityDto);
        }
        return  ResponseEntity.ok(entityDto);
    }

    @Override
    public EntityProcessor createNewInstance() {
        return new BasicProcessor();
    }
}
