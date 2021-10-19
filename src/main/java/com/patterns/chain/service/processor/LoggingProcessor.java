package com.patterns.chain.service.processor;

import com.patterns.chain.dto.EntityDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;

@Log4j2
public class LoggingProcessor extends EntityProcessor{

    @Override
    public ResponseEntity processEntity(EntityDto entityDto) {
        log.info("Processing with LoggingProcessor.");
        ResponseEntity responseEntity = null;
        //logging
        log.error("Processing of entity: " + entityDto);
        if(nextProcessor != null){
            responseEntity = nextProcessor.processEntity(entityDto);
        }

        log.error("Done processing entity ");
        return responseEntity == null ? ResponseEntity.ok(entityDto): responseEntity;
    }

    @Override
    public EntityProcessor createNewInstance() {
        return new LoggingProcessor();
    }
}
