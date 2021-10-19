package com.patterns.chain.service;

import com.patterns.chain.dto.EntityDto;
import com.patterns.chain.service.processor.EntityProcessor;
import com.patterns.chain.service.processor.ProcessorChain;
import com.patterns.chain.service.processor.ProcessorChainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntityServiceImpl implements EntityService{
    private final ProcessorChainService processorChainService;

    @Override
    public ResponseEntity processEntity(EntityDto entityDto) {
        ProcessorChain entityProcessorChain = processorChainService.createProcessorChain();
        return entityProcessorChain.process(entityDto);
    }
}
