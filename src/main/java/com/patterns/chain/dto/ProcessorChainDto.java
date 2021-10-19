package com.patterns.chain.dto;

import com.patterns.chain.service.processor.ProcessorShorName;
import lombok.Data;

import java.util.List;

@Data
public class ProcessorChainDto {
    List<ProcessorShorName> processorShorNames;
}
