package pages;


import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CommonMethod {
    public static JSONObject readJsonData(String file){
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = null;
        FileReader reader = null;
        String path = "src/test/java/data/input/";
        try {
            reader = new FileReader(path+file);
            jsonObject = (JSONObject) parser.parse(reader);
        } catch (IOException | ParseException e) {
          e.printStackTrace();
        }
        return jsonObject;
    }
}
