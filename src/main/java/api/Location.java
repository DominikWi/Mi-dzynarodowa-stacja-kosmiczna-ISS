package api;

import database.dao.IssLocationDao;
import database.daoimpl.IssLocationDaoImpl;
import database.entity.IssLocation;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.time.LocalDateTime;
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
        IssLocation issLocation=new IssLocation();
        IssLocationDao issLocationDao=new IssLocationDaoImpl();

            double szerokoscGeogr = Double.parseDouble(jsonLocation.getJSONObject("iss_position").getString("latitude"));
            double dlugoscGeogr = Double.parseDouble(jsonLocation.getJSONObject("iss_position").getString("longitude"));
            issLocation.setLatitude(szerokoscGeogr);
            issLocation.setLongitude(dlugoscGeogr);
            issLocation.setDate(LocalDateTime.now());
            issLocationDao.save(issLocation);
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
