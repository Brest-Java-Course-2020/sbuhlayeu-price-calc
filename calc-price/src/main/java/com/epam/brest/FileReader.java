package com.epam.brest;

import java.io.BufferedReader;
import java.io.IOException;

public class FileReader {
  public double read(String pathToFile) throws IOException {
        BufferedReader reader = new BufferedReader(new java.io.FileReader(pathToFile));
        String priceReader = reader.readLine();
        reader.close();
        return Double.parseDouble(priceReader);
    }
}
