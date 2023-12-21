package app;

import app.model.City;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        FileHandler fileHandler = new FileHandler();
        ArrayList<City> parsedCities = fileHandler.parseCSV("Задача ВС Java Сбер.csv");

        parsedCities.forEach(s -> System.out.println(s.toString()));

    }
}