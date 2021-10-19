package com.patterns.chain.service.processor;

import com.patterns.chain.dto.EntityDto;
import com.patterns.chain.dto.ErrorDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;

@Log4j2
public class SizeCheckProcessor extends EntityProcessor{

    @Override
    public ResponseEntity processEntity(ProcessorChain processorChain, EntityDto entityDto) {
        log.info("Processing with SizeCheckProcessor.");
        //Type conversion
        if(entityDto.getType().contains(" ")){
            if(entityDto.getType().length() > 5){
                entityDto.setType(entityDto.getType().replaceAll("\\s",""));
            }else{
                return ResponseEntity.badRequest().body(new ErrorDto("Type should have 5+ non whitespace characters"));
            }
        }
        return  processorChain.process(entityDto);
    }

    @Override
    public EntityProcessor createNewInstance() {
        return new SizeCheckProcessor();
    }
}
