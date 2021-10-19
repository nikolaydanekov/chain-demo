package com.patterns.chain.service.processor;

import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

import static com.patterns.chain.service.processor.ProcessorShorName.*;

@Service
public class ProcessorChainServiceImpl implements ProcessorChainService{
    private final Map<ProcessorShorName, EntityProcessor> processorMap = new HashMap<>();

    @Setter
    private List<ProcessorShorName> currentProcessors = new ArrayList<>();

    public ProcessorChainServiceImpl(){
        processorMap.put(NULL_CHECK, new NullCheckProcessor());
        processorMap.put(LOGGING, new LoggingProcessor());
        processorMap.put(TYPE, new TypeCheckProcessor());
        processorMap.put(SIZE, new SizeCheckProcessor());

        //default processors chain
        currentProcessors.addAll(Arrays.asList(LOGGING, NULL_CHECK, TYPE, SIZE));
    }

    @Override
    public ProcessorChain createProcessorChain() {
        List<EntityProcessor> entityProcessors = currentProcessors
                .stream()
                .map(processorMap::get)
                .collect(Collectors.toList());
        return new DefaultProcessorChain(entityProcessors);
    }


}
