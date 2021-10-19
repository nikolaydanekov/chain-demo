package com.patterns.chain.service.processor;

import java.util.List;

public interface ProcessorChainService {
    ProcessorChain createProcessorChain();

    void setCurrentProcessors(List<ProcessorShorName> currentProcessors);
}
