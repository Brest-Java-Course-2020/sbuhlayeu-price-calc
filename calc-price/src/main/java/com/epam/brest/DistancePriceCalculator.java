package com.epam.brest;

import java.io.IOException;

public class DistancePriceCalculator {
    FileReader DistancePriceReader;
    DistanceDiscountCalculator distanceDiscountCalculator;

    public DistancePriceCalculator() {
        this.DistancePriceReader = new FileReader();
        this.distanceDiscountCalculator = new DistanceDiscountCalculator();
    }

    public double calculatePrice(double distance) throws IOException {
        double discount = distanceDiscountCalculator.calculateDiscount(distance);
        double pricePerDistance = DistancePriceReader.read("/home/stanislav/development/sbuhlayeu-price-calc/calc-price/resources/pricePerDistance");

        if (discount > 0) {
            return distance * (pricePerDistance * discount);
        }
        return distance * pricePerDistance;
    }
}


