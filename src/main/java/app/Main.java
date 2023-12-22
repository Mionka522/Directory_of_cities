package app;

import app.model.City;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;

public class Main {
    public static void main(String[] args) {


        menu();
    }
        public static void menu(){
            Utils u = new Utils();
            int choice = u.getChoice();
            FileHandler fileHandler = new FileHandler();
            ArrayList<City> parsedCities = fileHandler.parseCSV("Задача ВС Java Сбер.csv");
            switch (choice) {

                case 1:
                    parsedCities.forEach(s -> System.out.println(s.toString()));
                    //Вывести список без сортировки, такой как в файле

                    menu();//возврат к выбору действия

                case 2:
                    parsedCities.sort((city1, city2) -> String.CASE_INSENSITIVE_ORDER.compare(city1.getName(), city2.getName()));
                    parsedCities.forEach(s -> System.out.println(s.toString()));
                    //Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра

                    menu(); //возврат в меню
                case 3:
                    parsedCities.sort(Comparator.comparing(City::getDistrict).thenComparing(City::getName));
                    parsedCities.forEach(s -> System.out.println(s.toString()));
                    //Сортировка списка городов по федеральному округу и наименованию города внутри каждого федерального
                    // округа в алфавитном порядке по убыванию с учетом регистра;

                    menu();//возврат в меню
                case 4:
                    System.out.println(u.searchMaxPopulation(parsedCities));
                    //Поиск города с наибольшим количеством жителей
                    menu();

                case 5:
                    // поиск количества городов в разрезе регионов
                    Map<String, Integer> regions = u.NumberOfCitiesInTheRegion(parsedCities);
                    for (Map.Entry<String, Integer> entry : regions.entrySet()) {
                        System.out.println(entry.getKey() + " = " + entry.getValue());

                    }
                    menu();


                case -1:
                    System.out.println("Завершение программы");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Не могу распознать команду с номерм  " + choice+"\nПопытайтесь еще раз");
                    menu();
            }

        }
    }