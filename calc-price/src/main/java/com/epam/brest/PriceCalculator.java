package com.epam.brest;

import java.io.IOException;

public class PriceCalculator {

    DistancePriceCalculator distancePriceCalculator;
    WeightPriceCalculator weightPriceCalculator;

    public PriceCalculator() {
        this.distancePriceCalculator = new DistancePriceCalculator();
        this.weightPriceCalculator = new WeightPriceCalculator();
    }

    public double calculatePrice(double distance, double weight) throws IOException {
        return distancePriceCalculator.calculatePrice(distance) + weightPriceCalculator.calculatePrice(weight);
    }
}
