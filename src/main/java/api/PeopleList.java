package api;


import org.json.JSONArray;
import org.json.JSONObject;
import java.io.IOException;
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



            JSONArray arr = jsonAstronauci.getJSONArray("people");
            for (int i = 0; i < arr.length(); i++) {
                String nameAstronaut = arr.getJSONObject(i).getString("name");


                System.out.println(nameAstronaut);
            }
        }
    }

