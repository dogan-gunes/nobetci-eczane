package com.dgn.resttemplateex.controller;

import com.dgn.resttemplateex.model.Request;
import com.dgn.resttemplateex.model.Response;
import com.dgn.resttemplateex.service.EczaneService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eczane")
public class EczaneController {

    private final EczaneService eczaneService;


    public EczaneController(EczaneService eczaneService) {
        this.eczaneService = eczaneService;
    }
    @GetMapping
    public ResponseEntity<Response> getEczane(@RequestBody Request request) throws JsonProcessingException {
        return new ResponseEntity<>(eczaneService.getEczane(request), HttpStatus.OK);
    }
}
