package com.rackspace;

import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;

import java.util.*;

/**
 * Write a function that if given sorted array of integers,
 * it will remove all the duplicates and return the unique list.
 *
 * @author Srikanth Chebrolu
 */

@Slf4j
public class NumberUtil {

    /**
     * Added to run the Below method
     **/
//    static Integer[] numbers = new Integer[] { 1, 1, 3, 3, 5, 7, 8, 8, 10 };
//    public static void main(String s[]) {
//        NumberUtil numberUtil = new NumberUtil();
//        List<String> uniqueNumbers = numberUtil.getUniqueNumbers(numbers);
//        log.info("Unique Numbers in a given List :: " + new Gson().toJson(uniqueNumbers));
//    }

    public List<Integer> getUniqueNumbers(Integer[] sortedArrayWithDuplicates) {
        Set<Integer> sortedArrayWithUniqueNumbers = new HashSet<>(Arrays.asList(sortedArrayWithDuplicates));
        log.info("sortedArrayWithUniqueNumbers: " + sortedArrayWithUniqueNumbers);
        return new ArrayList<>(sortedArrayWithUniqueNumbers);
    }

}
