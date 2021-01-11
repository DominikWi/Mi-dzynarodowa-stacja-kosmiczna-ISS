package main;

import api.IssPassTimes;
import api.Location;
import api.PeopleList;
import database.utils.HibernateUtils;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)  throws JSONException {

          /*  HibernateUtils
                .getInstance()
                .getSessionFactory()*/
                /*.close()*/;
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
              //lokalizacja iss
                /*Location location=new Location();
                location.whereIsNow();*/

               /*
                moja lokalizacja zapisana w systemie*/
                /*location.myLocation();*/

                //wyswietlanie kiedy znowu sie pojawi stacja
                IssPassTimes issPassTimes=new IssPassTimes();
                issPassTimes.whenItIs();

                /*wprowadz dowolna lokalizacje podajac szerok i dlug geogr
                location.randomLocation();*/


                break;
            case "c":
                PeopleList peopleList2=new PeopleList();
                peopleList2.howManyPeople();
                break;
            case "d":

                PeopleList peopleList=new PeopleList();
                peopleList.showPeople();

                break;

            case "e":

                System.out.println("Ciao");

            break;
            default:
                System.out.println("Zły wybor");
        }
    }
}



