package com.patterns.chain.service.processor;

import com.patterns.chain.dto.EntityDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;

@Log4j2
public class LoggingProcessor extends EntityProcessor{

    @Override
    public ResponseEntity processEntity(ProcessorChain processorChain, EntityDto entityDto) {
        log.info("Processing with LoggingProcessor.");
        ResponseEntity responseEntity = null;
        //logging
        log.error("Processing of entity: " + entityDto);
        responseEntity = processorChain.process(entityDto);
        log.error("Done processing entity ");
        return responseEntity;
    }

    @Override
    public EntityProcessor createNewInstance() {
        return new LoggingProcessor();
    }
}
