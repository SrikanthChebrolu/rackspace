package com.rackspace.controller;

import com.rackspace.model.ReverseStringResponse;
import com.rackspace.service.StringService;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import junit.framework.Assert;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StringControllerTest {

    @Mock
    private StringService stringService;

    @InjectMocks
    private StringController stringController;

    @After
    public void tearDown() throws Exception {
        stringController = null;
    }

    @Test
    public void testReversedString() {
        String reversedStringExpected = "World Hello";
        ReverseStringResponse reverseStringResponse = ReverseStringResponse.builder().reversed("World Hello").build();
        when(stringService.reverseString("Hello World")).thenReturn(reverseStringResponse);
        ResponseEntity<ReverseStringResponse> reversedStringEntity = stringController.getReverseString("Hello World");
        String reversedString = reversedStringEntity.getBody().getReversed();
        Assert.assertEquals(reversedStringExpected, reversedString);
    }

    @Test
    public void testReversedStringWithMultipleWords() {
        String reversedStringExpected = "world awesome hello";
        ReverseStringResponse reverseStringResponse = ReverseStringResponse.builder().reversed("world awesome hello").build();
        when(stringService.reverseString("hello awesome world")).thenReturn(reverseStringResponse);
        ResponseEntity<ReverseStringResponse> reversedStringEntity = stringController.getReverseString("hello awesome world");
        String reversedString = reversedStringEntity.getBody().getReversed();
        Assert.assertEquals(reversedStringExpected, reversedString);
    }

    @Test
    public void testReversedStringWithSingleWords() {
        String reversedStringExpected = "hello";
        ReverseStringResponse reverseStringResponse = ReverseStringResponse.builder().reversed("hello").build();
        when(stringService.reverseString("hello")).thenReturn(reverseStringResponse);
        ResponseEntity<ReverseStringResponse> reversedStringEntity = stringController.getReverseString("hello");
        String reversedString = reversedStringEntity.getBody().getReversed();
        Assert.assertEquals(reversedStringExpected, reversedString);
    }
}
