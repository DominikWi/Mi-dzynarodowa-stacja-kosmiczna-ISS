package api;


import database.dao.PeopleInSpaceDao;
import database.daoimpl.PeopleInSpaceDaoImpl;
import database.entity.PeopleInSpace;
import lombok.val;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static api.JsonReader.readJsonFromUrl;

public class PeopleList{
    JSONObject jsonAstronauci;
    {
        try {
            jsonAstronauci = readJsonFromUrl("http://api.open-notify.org/astros.json");
        } catch (IOException e) {
            e.printStackTrace();
        }}

    public void howManyPeople() {

        System.out.println("W kosmosie przebywa " + jsonAstronauci.get("number") + " osob.");

    }


   public void showPeople() {
       PeopleInSpace peopleInSpace=new PeopleInSpace();
       PeopleInSpaceDao peopleInSpaceDao = new PeopleInSpaceDaoImpl();
       List<String> listPeople =new ArrayList<>();

       JSONArray arr = jsonAstronauci.getJSONArray("people");
            for (int i = 0; i < arr.length(); i++) {
                String nameAstronaut = arr.getJSONObject(i).getString("name");
                listPeople.add(nameAstronaut);

            }
       System.out.println(listPeople);
        }
    }

