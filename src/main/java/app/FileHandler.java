package app;
import app.model.City;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;


public class FileHandler {
    public ArrayList<City> cities;

    public static ArrayList<City> read() throws IOException {
        ArrayList<City> cities = new ArrayList<>();

        Path path = Path.of("Задача ВС Java Сбер.csv");
        Files.lines(path)
                .map(line -> {
                    String[] fields = line.split(";");
                    return new City(Integer.parseInt(fields[0]),fields[1], fields[2], fields[3],Integer.parseInt(fields[4]),fields[5]);
                }).forEach(cities::add);

        return cities;

        }

    }
