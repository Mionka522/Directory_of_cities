package app;

import app.model.City;

import java.util.*;

public class Utils {
    Scanner in = new Scanner(System.in);
    public int getIntInput() {
        // метод вызывается каждый раз, когда любой метод
        // использует вызов System.out.println() для того,
        // чтобы запросить у пользователя значение int

        return in.nextInt();
    }
    public int getChoice() {
        //Вывод информации о существующих командах

        System.out.println("\nВывести список городов :\n" +"\n"+
                "================================\n" +"\n"+
                "1) без сортировки\n" +
                "2) Сортировка списка городов по наименованию в алфавитном порядке по убыванию без учета регистра\n" +
                "3) Сортировка списка городов по федеральному округу и наименованию города внутри каждого федерального округа в алфавитном порядке по убыванию с учетом регистра\n" +
                "4) Поиск города с наибольшим количеством жителей\n"+
                "5) Поиск количества городов в разрезе регионов\n"+

                "Выберите вариант сортировки списка (или введите -1 чтобы выйти):\n" +

                "\n"+"Выберете действие: ");
        return getIntInput();
    }

    public String searchMaxPopulation(ArrayList<City> cities) {
        //Поиск города с наибольшим количеством жителей
        cities.sort(Comparator.comparingInt(City::getPopulation));
        City PopulousCity = cities.getLast();

        return "["+PopulousCity.getIndex()+"]"+"="+PopulousCity.getPopulation();
    }

    public Map<String, Integer> NumberOfCitiesInTheRegion(ArrayList<City> cities) {
        // поиск количества городов в разрезе регионов
        return cities.stream().collect(HashMap::new, (m, c) -> {
            if(m.containsKey(c.getRegion()))
                m.put(c.getRegion(), m.get(c.getRegion()) + 1);
            else
                m.put(c.getRegion(), 1);
        }, HashMap::putAll);
    }


}
