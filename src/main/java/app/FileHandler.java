package app;
import org.apache.commons.csv.*;
import org.apache.commons.csv.CSVRecord;
import app.model.City;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;


public class FileHandler {


    public ArrayList<City> parseCSV(String filePath) {
        ArrayList<City> cities = new ArrayList<>();

        try (Reader reader = Files.newBufferedReader(Paths.get(filePath));
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.withDelimiter(';'))) {

            for (CSVRecord csvRecord : csvParser) {
                // Создайте новый объект и заполните его значениями из CSV записи
                City city = new City();
                city.setIndex(Integer.parseInt(csvRecord.get(0)));
                city.setName(csvRecord.get(1));
                city.setRegion(csvRecord.get(2));
                city.setDistrict(csvRecord.get(3));
                city.setPopulation(Integer.parseInt(csvRecord.get(4)));
                city.setFoundation(csvRecord.get(5));
                cities.add(city);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return cities;
    }




}

