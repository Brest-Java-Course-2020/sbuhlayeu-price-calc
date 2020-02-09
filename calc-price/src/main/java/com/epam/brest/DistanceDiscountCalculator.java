package com.epam.brest;

public class DistanceDiscountCalculator {

    public double calculateDiscount(double distance) {
        if (distance >= 300 && distance < 500) {
            return 0.15;
        }

        if (distance >= 500 && distance < 1000) {
            return 0.25;
        }

        if (distance >= 1000) {
            return 0.50;
        }

        return 0;
    }
}
