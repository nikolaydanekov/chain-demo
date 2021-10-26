package com.patterns.chain.controller;

import com.patterns.chain.dto.EntityDto;
import com.patterns.chain.dto.ProcessorChainDto;
import com.patterns.chain.service.EntityService;
import com.patterns.chain.service.processor.ProcessorChainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/process")
@RequiredArgsConstructor
public class ProcessingController {
    private final EntityService entityService;
    private final ProcessorChainService processorChainService;

    @PostMapping(produces = "application/json")
    public ResponseEntity processEntity(@RequestBody EntityDto entityDto){
        return entityService.processEntity(entityDto);
    }

    @PostMapping(path = "/chain", produces = "application/json")
    public void setProcessorChain(@RequestBody ProcessorChainDto processorChainDto){
        processorChainService.setCurrentProcessors(processorChainDto.getProcessorShorNames());
    }
}
