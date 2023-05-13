package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class StreamHashMapFilter {

    public static void main(String[] args) {

        Map<String, Integer> ages = new HashMap<>();

        ages.put("john", 20);
        ages.put("mark", 25);
        ages.put("frank", 18);

        Map<String, Integer> filteredAge = ages.entrySet()
                .stream()
                .filter(age -> 21 < age.getValue())
                .collect(Collectors.toMap(
                        key -> key.getKey(), value -> value.getValue()
                ));

        System.out.println("Result: " + filteredAge);
    }
}
