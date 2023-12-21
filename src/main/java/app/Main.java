package app;

import app.model.City;

import java.io.IOException;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
       var r = FileHandler.read();
       r.forEach(System.out::println);
    }
}