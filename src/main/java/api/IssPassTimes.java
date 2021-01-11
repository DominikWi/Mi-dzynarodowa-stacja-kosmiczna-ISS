package api;

import database.entity.UserLocation;
import org.json.JSONArray;
import org.json.JSONObject;

import javax.json.Json;
import java.io.IOException;

import static api.JsonReader.readJsonFromUrl;

public class IssPassTimes {
    JSONObject jsonIssListaZdarzen;
   // UserLocation userLocation = new UserLocation();

    //POPRAWIC WPROWADZANIE ABY POBIERALO DANE Z NASZEJ LOKALIZACJI
            String LON="54.074253";
            String LAT= "9.984466";
            String UrlListaZdarzen ="http://api.open-notify.org/iss-pass.json?lat="+LAT+"&lon="+LON;

    {
        try {
            jsonIssListaZdarzen = readJsonFromUrl(UrlListaZdarzen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void whenItIs() {

        JSONArray arr = jsonIssListaZdarzen.getJSONArray("response");
        for (int i = 0; i < arr.length(); i++) {
            Double IssRisetime = arr.getJSONObject(i).getDouble("risetime");
            Double IssDuration = arr.getJSONObject(i).getDouble("duration");
            System.out.println(IssDuration+ " duration");
            System.out.println(IssRisetime+ " rise time");

            //POBIERA DANE TRZEBA TYLKO ZEDYTOWAC JEDNOSTKI W JAKICH WYSWIETLA
        }
    }
}
//{
//  "message": "success",
//  "request": {
//    "latitude": LATITUE,
//    "longitude": LONGITUDE,
//    "altitude": ALTITUDE,
//    "passes": NUMBER_OF_PASSES,
//    "datetime": REQUEST_TIMESTAMP
//  },
// "response": [
//    {"risetime": TIMESTAMP, "duration": DURATION},
//    ...
//  ]