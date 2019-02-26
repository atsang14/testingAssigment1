package homework1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.HashMap;

public class PostProcessor implements Processor {
    public PostProcessor(HashMap<String, String> hmap) {}

    public String process(HashMap<String, String> hmap) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader("./data.json"));
            JsonParser jsonParser = new JsonParser();

            // Storing info from data.json file in JSON format in obj variable
            JsonObject obj = jsonParser.parse(br).getAsJsonObject();
            Posts[] posts = gson.fromJson(obj.get("posts"), Posts[].class);
            Posts.loadAll();
            Response response = new Response();
            String useridString = hmap.get("userid");
            int userid = Integer.parseInt(useridString);
            response.setPosts(new Posts[]{Posts.getUser(userid)});
            response.setParams(hmap);
            String jsonString = gson.toJson(response);
            return jsonString;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("Hello from PostssRoute process()");
        return "ERROR";
    }
}