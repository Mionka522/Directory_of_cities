package app;

import app.model.City;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {


        menu();
    }
        public static void menu(){
            Choice c;
            c = new Choice();
            int choice = c.getChoice();
            FileHandler fileHandler = new FileHandler();
            ArrayList<City> parsedCities = fileHandler.parseCSV("Задача ВС Java Сбер.csv");
            switch (choice) {

                case 1:
                    parsedCities.forEach(s -> System.out.println(s.toString()));
                    //Вывести список без сортировки, такой как в файле

                    menu();//возврат к выбору действия

                case 2:
                    Collections.sort(parsedCities, (city1, city2) -> String.CASE_INSENSITIVE_ORDER.compare(city1.getName(), city2.getName()));
                    parsedCities.forEach(s -> System.out.println(s.toString()));
                    //Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра

                    menu(); //возврат в меню
                case 3:
                    Collections.sort(parsedCities, Comparator.comparing(City::getDistrict).thenComparing(City::getName));
                    parsedCities.forEach(s -> System.out.println(s.toString()));
                    //Сортировка списка городов по федеральному округу и наименованию города внутри каждого федерального
                    // округа в алфавитном порядке по убыванию с учетом регистра;

                    menu();//возврат в меню


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