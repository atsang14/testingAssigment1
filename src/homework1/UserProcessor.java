package homework1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class UserProcessor implements Processor {
    public UserProcessor(HashMap<String, String> hmap) {}

    public String process(HashMap<String, String> hmap) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader br;
        try {
//            br = new BufferedReader(new FileReader("/Users/austintsang/Desktop/CSC413/hw/hw1/hw1-awkwardstart/data.json"));
            br = new BufferedReader(new FileReader("./data.json"));
            JsonParser jsonParser = new JsonParser();

            // Storing info from data.json file in JSON format in obj variable
            JsonObject obj = jsonParser.parse(br).getAsJsonObject();
            User[] users = gson.fromJson(obj.get("users"), User[].class);
            User.loadAll();
//            int userElement = Integer.parseInt(args[2]);
            Response response = new Response();

            String useridString = hmap.get("userid");

            int userid = Integer.parseInt(useridString);
            response.setUsers(new User[]{User.getUser(userid)});
            response.setParams(hmap);

            String jsonString = gson.toJson(response);
            return jsonString;

        } catch (FileNotFoundException | NumberFormatException e) {
            e.printStackTrace();
            return "ERROR";
        }
    }
}