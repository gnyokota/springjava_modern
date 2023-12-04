package com.modern.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class BinarySearchImpl {
    @Autowired
    SortAlgorithm sortAlgorithm;

    public int binarySearch(int[] numbers, int numberToSearch) {
        System.out.println(Arrays.toString(sortAlgorithm.sort(numbers)));
        return Arrays.stream(numbers).filter(it -> it == numberToSearch).toArray()[0];
    }
}
