package com.epam.brest;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static PriceCalculator priceCalculator = new PriceCalculator();

    public static void main(String[] args) throws IOException {
        while (true) {
            String input;

            System.out.println("Please, enter distance or Q for exit: ");
            input = scanner.nextLine();

            if (isExitValue(input)) {
                break;
            }

            double distance = inputValue(input);

            System.out.println("Please, enter weight or Q for exit: ");
            input = scanner.nextLine();

            if (isExitValue(input)) {
                break;
            }

            double weight = inputValue(input);
            double result = priceCalculator.calculatePrice(distance, weight);
            System.out.println("Result: $" + result);
        }

    }

    private static double inputValue(String input) {
        if (isCorrectDoubleValue(input)) {
            return Double.parseDouble(input);
        } else {
            System.out.println("Incorrect input, try again");
            String inputVal = scanner.nextLine();
            return inputValue(inputVal);
        }
    }

    private static boolean isExitValue(String value) {
        return value.equalsIgnoreCase("Q");
    }

    private static boolean isCorrectDoubleValue(String value) {
        boolean checkResult;
        try {
            double enteredDoubleValue = Double.parseDouble(value);
            checkResult = enteredDoubleValue > 0;
        } catch (NumberFormatException ex) {
            checkResult = false;
        }
        return checkResult;
    }
}