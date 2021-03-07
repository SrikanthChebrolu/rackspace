package com.rackspace;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class NumberUtilTests {

    private NumberUtil numberUtil;

    @Before
    public void setUp() {
        numberUtil = new NumberUtil();
    }

    @After
    public void tearDown() { numberUtil = null; }

    @Test
    public void testGetUniqueNumbersSortedOrderShouldPass() {
        Integer[] sortedArray = new Integer[] { 1, 1, 3, 3, 5, 7, 8, 8, 10 };
        List<Integer> expectedUniqueNumbers = new ArrayList<>(Arrays. asList(1, 3, 5, 7, 8, 10));
        List<Integer> uniqueNumbers = numberUtil.getUniqueNumbers(sortedArray);
        Assert.assertEquals(expectedUniqueNumbers, uniqueNumbers);
    }

    @Test
    public void testGetUniqueNumbersUnsortedOrderShouldFail() {
        Integer[] sortedArray = new Integer[] { 3, 1, 3, 4, 5, 4, 8, 8, 10 };
        List<Integer> expectedUniqueNumbers = new ArrayList<>(Arrays. asList(1, 3, 4, 5, 8, 10));
        List<Integer> uniqueNumbers = numberUtil.getUniqueNumbers(sortedArray);
        Assert.assertEquals(expectedUniqueNumbers, uniqueNumbers);
    }

    @Test
    public void testGetUniqueNumbersIsEmpty() {
        Integer[] sortedArray = new Integer[] {};
        List<Integer> expectedUniqueNumbers = new ArrayList<>(Arrays. asList());
        List<Integer> uniqueNumbers = numberUtil.getUniqueNumbers(sortedArray);
        Assert.assertEquals(expectedUniqueNumbers, uniqueNumbers);
    }

    @Test
    public void testGetUniqueNumbersWithOneValue() {
        Integer[] sortedArray = new Integer[] {1};
        List<Integer> expectedUniqueNumbers = new ArrayList<>(Arrays. asList(1));
        List<Integer> uniqueNumbers = numberUtil.getUniqueNumbers(sortedArray);
        Assert.assertEquals(expectedUniqueNumbers, uniqueNumbers);
    }
}
