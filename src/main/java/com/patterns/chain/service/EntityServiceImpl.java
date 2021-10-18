package com.patterns.chain.service;

import com.patterns.chain.dto.EntityDto;
import com.patterns.chain.dto.ErrorDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class EntityServiceImpl implements EntityService{
    @Override
    public ResponseEntity processEntity(EntityDto entityDto) {
        //logging
        log.error("Processing of entity: " + entityDto);

        //Type conversion
        if(entityDto.getType().contains(" ")){
            if(entityDto.getType().length() > 5){
                entityDto.setType(entityDto.getType().replaceAll("\\s",""));
            }else{
                return ResponseEntity.badRequest().body(new ErrorDto("Type should have 5+ non whitespace characters"));
            }
        }

        //Length validation
        if(entityDto.getSize()!= null && entityDto.getName().length()+entityDto.getType().length() != entityDto.getSize()){
            return ResponseEntity.badRequest().body(new ErrorDto("Size no applicable"));
        }

        log.error("Done processing entity ");
        return ResponseEntity.ok(entityDto);
    }
}
