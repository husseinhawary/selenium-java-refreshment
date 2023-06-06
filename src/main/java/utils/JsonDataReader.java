package utils;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {
    public String userName;
    public String userPassword;
    public void JsonReader() throws IOException, ParseException {
        String filePath = System.getProperty("user.dir") + "/src/test/data/UserData.json";
        File srcFile = new File(filePath);

        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArray = (JSONArray) jsonParser.parse(new FileReader(srcFile));

        for (Object jsonObject : jsonArray){
            JSONObject user = (JSONObject) jsonObject;
            userName = (String) user.get("userName");
            userPassword = (String) user.get("password");
        }
    }
}
