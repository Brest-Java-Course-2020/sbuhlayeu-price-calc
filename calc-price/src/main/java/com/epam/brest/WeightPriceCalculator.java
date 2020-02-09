package com.epam.brest;

import java.io.IOException;

public class WeightPriceCalculator {
    FileReader WeightPriceReader;
    WeightDiscountCalculator weightDiscountCalculator;

    public WeightPriceCalculator() {
        this.WeightPriceReader = new FileReader();
        this.weightDiscountCalculator = new WeightDiscountCalculator();
    }

    public double calculatePrice(double weight) throws IOException {
        double discount = weightDiscountCalculator.calculateDiscount(weight);
        double pricePerWeight = WeightPriceReader.read("/home/stanislav/development/sbuhlayeu-price-calc/calc-price/resources/pricePerWeight");
        // double pricePerWeight = 2;
        if (discount > 0) {
            return weight * (pricePerWeight * discount);
        }
        return weight * pricePerWeight;
    }
}
