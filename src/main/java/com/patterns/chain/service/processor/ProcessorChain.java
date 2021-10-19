package com.patterns.chain.service.processor;

import com.patterns.chain.dto.EntityDto;
import org.springframework.http.ResponseEntity;

public interface ProcessorChain {
    ResponseEntity process(EntityDto entityDto);
}
