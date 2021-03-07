package com.rackspace.controller;

import com.google.gson.Gson;
import com.rackspace.model.ReverseStringResponse;
import com.rackspace.service.StringService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class StringController {

    @Autowired
    StringService stringService;

    @GetMapping(value = "/api/{inputString}")
    public ResponseEntity<ReverseStringResponse> getReverseString(@PathVariable("inputString") String inputString) {
        ReverseStringResponse reverseStringResponse = stringService.reverseString(inputString);
        log.info("reverseStringResponse :: "+ new Gson().toJson(reverseStringResponse));
        return new ResponseEntity<>(reverseStringResponse, HttpStatus.OK);
    }
}
