package com.patterns.chain.service.processor;

import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.*;

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
    public EntityProcessor createProcessorChain() {
        EntityProcessor rootProcessor = new BasicProcessor();
        EntityProcessor lastProcessor = currentProcessors.stream()
                .map(processorShortName -> processorMap.get(processorShortName).createNewInstance())
                .reduce(rootProcessor, (processor1, processor2) -> {
                    processor1.setNextProcessor(processor2);
                    return processor2;
                });
        //make sure there are no leftovers from precious creations
        lastProcessor.setNextProcessor(null);
        return rootProcessor;
    }


}
