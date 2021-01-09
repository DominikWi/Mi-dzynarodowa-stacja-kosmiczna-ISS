package api;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import static api.JsonReader.readJsonFromUrl;

public class PeopleList{
    JSONObject jsonAstronauci;

   public void showPeople() {
        {
            try {
                jsonAstronauci = readJsonFromUrl("http://api.open-notify.org/astros.json");
            } catch (IOException e) {
                e.printStackTrace();
            }

            JSONArray arr = jsonAstronauci.getJSONArray("people");
            for (int i = 0; i < arr.length(); i++) {
                String nameAstronaut = arr.getJSONObject(i).getString("name");

                System.out.println(nameAstronaut);
            }
        }
    }
}
