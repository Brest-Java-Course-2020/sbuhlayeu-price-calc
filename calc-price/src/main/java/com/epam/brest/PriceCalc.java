package com.epam.brest;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PriceCalc {
    public void priceCalculation() throws IOException {
        Double[] enteredValues = new Double[4];
        Scanner scanner = new Scanner(System.in);
        String inputValue;
        Double calcResult;

        int i = 0;

        do {
            switch (i) {
                case 0: System.out.println("Please, enter distance or Q for exit: "); break;
                case 1: System.out.println("Please, enter price per km or Q for exit: "); break;
                case 2: System.out.println("Please, enter weight or Q for exit: "); break;
                case 4: {
                    if (enteredValues[0] >= 1000 && enteredValues[2] < 1000) {
                        calcResult = enteredValues[0] * (enteredValues[1] * 0.50) + enteredValues[2] * enteredValues[3];
                    } else if (enteredValues[2] >= 1000 && enteredValues[0] < 1000) {
                        calcResult = enteredValues[0] * enteredValues[1] + enteredValues[2] * (enteredValues[3] * 0.50);
                    } else if (enteredValues[0] >= 1000 && enteredValues[2] >= 1000) {
                        calcResult = enteredValues[0] * (enteredValues[1] * 0.50) + enteredValues[2] * (enteredValues[3] * 0.50);
                    } else {
                        calcResult = enteredValues[0] * enteredValues[1] + enteredValues[2] * enteredValues[3];
                    }
                    System.out.println("Price: $" + calcResult);
                    i = 0;

                    FileWriter fileWriter = new FileWriter("//home//stanislav//development//sbuhlayeu-price-calc//calc-price//resources//TransportationCost", true);
                    fileWriter.write("Price per distance: " + enteredValues[1] + "\nPrice per weight: " + enteredValues[3] + "\nCost: " + calcResult + "\n\n");
                    fileWriter.flush();
                    fileWriter.close();

                }
                default: System.out.println("Please, enter price per kg or Q for exit: ");
            }

            inputValue = scanner.next();
            if (!isExitValue(inputValue) && isCorrectDoubleValue(inputValue)) {
                enteredValues[i] = Double.parseDouble(inputValue);
                i++;
            }
        } while (!isExitValue(inputValue));
        System.out.println("Finish!");

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
