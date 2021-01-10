package api;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.Scanner;

import static api.JsonReader.readJsonFromUrl;

public class Location {
    JSONObject jsonLocation;

    {
        try {
            jsonLocation = readJsonFromUrl("http://api.open-notify.org/iss-now.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void whereIsNow() {

            String szerokoscGeogr = jsonLocation.getJSONObject("iss_position").getString("latitude");
            String dlugoscGeogr = jsonLocation.getJSONObject("iss_position").getString("longitude");

            System.out.println(szerokoscGeogr + " szerokosc");
            System.out.println(dlugoscGeogr + " dlugosc");
        }
        public void myLocation(){

           double myLongitude= 54.074253;
           double mylatitude=9.984466 ;
            System.out.println("54.074253 szerokosc");
            System.out.println("9.984466 dlugosc");

        }
        public void randomLocation(){
            Scanner scan = new Scanner(System.in);
            System.out.println("Podaj szerokosc geograficzna");
            Double wybSzerokosc = scan.nextDouble();


            System.out.println("Podaj dlugosc geograficzna");
            Double wybDlugosc = scan.nextDouble();

            System.out.println(wybSzerokosc+" szerokosc");
            System.out.println(wybDlugosc+" dlugosc");
        }

    }
