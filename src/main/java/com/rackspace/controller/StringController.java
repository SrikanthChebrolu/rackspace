package com.rackspace.controller;

import com.google.gson.Gson;
import com.rackspace.model.ReverseStringResponse;
import com.rackspace.service.StringService;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * Make a rest api that takes a string and reverses the order of the words. So if I submit
 * http://localhost/api/Hello%20World, I would get the following json response: {“reversed”:
 * “World Hello”}
 *
 * @author Srikanth Chebrolu
 */
@RestController
@Slf4j
public class StringController {

    @Setter
    private StringService stringService;

    @Autowired
    public StringController(StringService stringService){
        this.stringService = stringService;
    }

    @GetMapping(value = "/api/{inputString}")
    public ResponseEntity<ReverseStringResponse> getReverseString(@PathVariable("inputString") String inputString) {
        ReverseStringResponse reverseStringResponse = stringService.reverseString(inputString);
        log.info("reverseStringResponse :: "+ new Gson().toJson(reverseStringResponse));
        return new ResponseEntity<>(reverseStringResponse, HttpStatus.OK);
    }
}
