package com.dgn.resttemplateex.service;

import com.dgn.resttemplateex.model.Request;
import com.dgn.resttemplateex.model.Response;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import static java.lang.StringTemplate.STR;

@Service
public class EczaneService {

    private static final String API_KEY="apikey 2d7jWYoYuE0LyPKJon39aH:4ULOuAfm3LgCZldOgjWoAC";
    private static final String URL="https://api.collectapi.com/health/dutyPharmacy?ilce=";

    private final RestTemplate restTemplate;
    private final ObjectMapper objectMapper;

    public EczaneService(RestTemplate restTemplate, ObjectMapper objectMapper) {
        this.restTemplate = restTemplate;
        this.objectMapper = objectMapper;
    }

    public Response getEczane(Request request) throws JsonProcessingException {
        String request_url=STR."\{URL}\{request.getIlce()}&il=\{request.getIl()}";
        HttpHeaders headers=new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("authorization",API_KEY);
        HttpEntity<Void> requestEntity=new HttpEntity<>(headers);
        ResponseEntity<String> response =restTemplate.exchange(request_url, HttpMethod.GET,requestEntity, String.class);
        Response results=objectMapper.readValue(response.getBody(),Response.class);
        return results;
    }

}
