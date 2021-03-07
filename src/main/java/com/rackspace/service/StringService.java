package com.rackspace.service;

import com.rackspace.model.ReverseStringResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class StringService {
    public ReverseStringResponse reverseString(String inputString) {
        log.info("input string :"+ inputString);
        String reversedString = "";
        try {
            String words[] = inputString.split("\\s");
            if(words.length == 1) {
                log.info("Only One String present in the given sentence :: "+ inputString);
                return new ReverseStringResponse(inputString);
            }
            for (int i = 0; i < words.length; i++) {
                if (i == words.length - 1)
                    reversedString = words[i] + reversedString;
                else
                    reversedString = " " + words[i] + reversedString;
            }
            log.info("reversed string :"+ reversedString);
        } catch (Exception e) {
            log.error("exception occurred while processing reverse string:"+ e.getMessage());
        }
        return  new ReverseStringResponse(reversedString);
    }

}
