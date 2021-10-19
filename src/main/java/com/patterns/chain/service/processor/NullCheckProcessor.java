package com.patterns.chain.service.processor;

import com.patterns.chain.dto.EntityDto;
import com.patterns.chain.dto.ErrorDto;
import lombok.Builder;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;

@Log4j2
public class NullCheckProcessor extends EntityProcessor{


    @Override
    public ResponseEntity processEntity(EntityDto entityDto) {
        log.info("Processing with NullCheckProcessor.");
        //Null check
        if(entityDto.getName() == null && entityDto.getType() == null){
            return ResponseEntity.badRequest().body(new ErrorDto("Name should not be  null"));
        }else if(nextProcessor != null){
            return nextProcessor.processEntity(entityDto);
        }
        return ResponseEntity.ok(entityDto);
    }

    @Override
    public EntityProcessor createNewInstance() {
        return new NullCheckProcessor();
    }

}
