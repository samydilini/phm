package org.phm;

import org.apache.commons.lang3.StringUtils;
import org.phm.service.CalculationService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("#############################");
        System.out.println("Welcome to math solution");
        System.out.println("Add numbers to add to the array \n to calculate enter C");
        System.out.println("Enter the first number");
        Scanner scanner = new Scanner(System.in);
        String inString;
        List<Integer> numbers = new ArrayList<>();
        do {
            inString = scanner.nextLine().trim().toUpperCase();
            if (StringUtils.isNumeric(inString)) {
                numbers.add(Integer.parseInt(inString));
                System.out.println("Enter the next number or C");
            } else if(inString.equalsIgnoreCase("c")) {
                System.out.println(inString + " is not a number input. Enter a valid number or C");
            }

        } while (!inString.equals("C"));
        System.out.println("Calculating the values .....................");
        scanner.close();
        CalculationService calculationService = new CalculationService();
        Solution result = calculationService.calculate(numbers.stream().mapToInt(i -> i).toArray());
        System.out.println("Equation is :");
        System.out.println(result.equation());
        System.out.println("Answer is :" + result.answer());
        System.out.println("#############################");
    }
}