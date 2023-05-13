package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class StreamHashMapFilter {

    /**
     * Kullanıcıların adlarını ve yaşlarını dönen bir response'umuz olduğunu düşünelim.
     * Daha sonrasında da HashMap'imizin içine girelim ve dönen response'taki value(age) > 21'den büyükse bu kullanıcıları filtreleyip bir listeye koysun ve daha sonrasında bu oluşan listenin outputunu görelim.
     * @param args
     */
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
