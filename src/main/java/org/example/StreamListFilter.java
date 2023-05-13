package org.example;

import java.util.*;
import java.util.function.*;

public class StreamListFilter {

    private static final Scanner sc = new Scanner(System.in);

    private static final String PEGASUS = "pegasus";
    private static final String THY = "thy";
    private static final String SUN_EXPRESS = "sunexpress";
    private static final String ANADOLU_JET = "anadolujet";

    public static void main(String[] args) {

        List<String> airlinesList = Arrays.asList(PEGASUS, THY, PEGASUS, SUN_EXPRESS, ANADOLU_JET, PEGASUS);

       airlinesFilter(airlinesList);

//        streamAirlinesFilter(airlinesList);
    }

    /**
     * For each kullanılarak airline filtrelemesi yapar.
     * @param airlinesList içine Airline'ların olduğu bir liste alır.
     */
    private static void airlinesFilter(List<String> airlinesList) {
        List<String> filteredAirlinesList = new ArrayList<>();

        System.out.println("Please enter the airline name : ");

        String inputAirline = sc.nextLine();

        String airlineName = inputAirline.toLowerCase();

        System.out.println("Selected Airline : " + airlineName);

        for (String airline : airlinesList) {

            boolean isEqualsAirline = airline.equals(airlineName);
            if (isEqualsAirline) {
                filteredAirlinesList.add(airline);

                boolean isAirlinesSizeTwo = filteredAirlinesList.size() == 2;
                if (isAirlinesSizeTwo) break;
            }
        }
        checkValidAirlinesControl(filteredAirlinesList);
    }

    /**
     * Stream filter kullanılarak airline filtrelemesi yapar.
     * @param airlinesList içine Airline'ların olduğu bir liste alır.
     */
    private static void streamAirlinesFilter(List<String> airlinesList) {
        List<String> filteredAirlinesList;

        System.out.println("Please enter the airline name : ");

        String inputAirline = sc.nextLine();

        String airlineName = inputAirline.toLowerCase();

        System.out.println("Selected Airline : " + airlineName);

        Predicate<String> airlineFilterCondition = airline -> airline.equals(airlineName);

        filteredAirlinesList = airlinesList
                                    .stream()
                                    .filter(airlineFilterCondition)
                                    .limit(2)
                               .toList();

        checkValidAirlinesControl(filteredAirlinesList);
    }

    /**
     * Validasyon metotudur. Kullanıcıya olası bir yanlış input verişinde hata döner, eğer doğru airline ismi verirse de listeyi ve listede kaç tane uçuş olduğunu gösterir.
     * @param filteredAirlinesList
     */
    private static void checkValidAirlinesControl(List<String> filteredAirlinesList) {
        if (filteredAirlinesList.isEmpty()) System.out.println("Invalid airline name , please try again !");
        else System.out.println(filteredAirlinesList + ", List size = " + filteredAirlinesList.size());
    }
}
