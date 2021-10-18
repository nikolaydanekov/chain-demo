package com.patterns.chain.controller;

import com.patterns.chain.dto.EntityDto;
import com.patterns.chain.service.EntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/process")
@RequiredArgsConstructor
public class ValidationController {
    private final EntityService entityService;

    @PostMapping(produces = "application/json")
    public ResponseEntity transformEntity(@RequestBody EntityDto entityDto){
        return entityService.processEntity(entityDto);
    }
}
