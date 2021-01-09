package main;

import api.PeopleList;
import database.entity.IssLocation;
import database.utils.HibernateUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

import static api.JsonReader.readJsonFromUrl;

public class Main {

    private static JSONArray obj;

    public static void main(String[] args)  throws IOException, JSONException {
        JSONObject jsonAstronauci = readJsonFromUrl("http://api.open-notify.org/astros.json");
        JSONObject jsonLokalizacja = readJsonFromUrl("http://api.open-notify.org/iss-now.json");

            HibernateUtils
                .getInstance()
                .getSessionFactory()
                .close();
        System.out.println("a - Podaj predkosc ISS");
        System.out.println("b - Wyswietl liste nadchodzacych przebiegow ISS dla okreslonej lokalizacji");
        System.out.println("c - Wyswietl liczbe osob przebywajacych w kosmosie w ramach ISS");
        System.out.println("d - Wyswietl liste osob przebywajacych w kosmosie w ramach ISS");
        System.out.println("e - Wyjscie");
        Scanner scan = new Scanner(System.in);
        String choice = scan.nextLine();
        switch (choice) {
            case "a":
                System.out.println("Predkosc ISS wynosi ~ 28,000 km/h ");
                break;
            case "b":
              //lokalizacja do ogarniecia

                break;
            case "c":
                System.out.println("W kosmosie przebywa " +jsonAstronauci.get("number")+ " osob.") ;
            case "d":

                PeopleList peopleList=new PeopleList();
                peopleList.showPeople();


                break;

            case "e":
                System.out.println("Ciao");
            default:
                System.out.println("Zły wybor");
        }
    }
}



