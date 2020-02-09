package com.epam.brest;

public class WeightDiscountCalculator {

    public double calculateDiscount(double weight) {
        if (weight >= 300 && weight < 500) {
            return 0.15;
        }

        if (weight >= 500 && weight < 1000) {
            return 0.25;
        }

        if (weight >= 1000) {
            return 0.50;
        }

        return 0;
    }
}
