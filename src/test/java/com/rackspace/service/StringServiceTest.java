package com.rackspace.service;

import com.rackspace.model.ReverseStringResponse;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;


public class StringServiceTest {

    @InjectMocks
    private StringService stringService;

    @Before
    public void setUp() throws Exception {
        stringService = new StringService();
    }

    @After
    public void tearDown() throws Exception {
        stringService = null;
    }

    @Test
    public void testReversedString() {
        String reversedStringExpected = "World Hello";
        ReverseStringResponse reversedStringEntity = stringService.reverseString("Hello World");
        String reversedString = reversedStringEntity.getReversed();
        Assert.assertEquals(reversedStringExpected, reversedString);
    }

    @Test
    public void testReversedStringWithMultipleWords() {
        String reversedStringExpected = "world awesome hello";
        ReverseStringResponse reversedStringEntity = stringService.reverseString("hello awesome world");
        String reversedString = reversedStringEntity.getReversed();
        Assert.assertEquals(reversedStringExpected, reversedString);
    }

    @Test
    public void testReversedStringWithSingleWords() {
        String reversedStringExpected = "hello";
        ReverseStringResponse reversedStringEntity = stringService.reverseString("hello");
        String reversedString = reversedStringEntity.getReversed();
        Assert.assertEquals(reversedStringExpected, reversedString);
    }

    @Test
    public void testReversedStringWithNull() {
        String reversedStringExpected = "";
        ReverseStringResponse reversedStringEntity = stringService.reverseString(null);
        String reversedString = reversedStringEntity.getReversed();
        Assert.assertEquals(reversedStringExpected, reversedString);
    }
}
