package com.patterns.chain.service.processor;

import com.patterns.chain.dto.EntityDto;
import com.patterns.chain.dto.ErrorDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;

@Log4j2
public class TypeCheckProcessor extends EntityProcessor{

    @Override
    public ResponseEntity processEntity(ProcessorChain processorChain, EntityDto entityDto) {
        log.info("Processing with TypeCheckProcessor.");
        //Type conversion
        if(entityDto.getSize()!= null && entityDto.getName().length()+entityDto.getType().length() != entityDto.getSize()){
            return ResponseEntity.badRequest().body(new ErrorDto("Size correct applicable"));
        }
        return processorChain.process(entityDto);
    }

    @Override
    public EntityProcessor createNewInstance() {
        return new TypeCheckProcessor();
    }
}
