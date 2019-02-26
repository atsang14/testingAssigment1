package homework1;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.util.HashMap;

public class MathProcessor implements Processor {
    public MathProcessor(HashMap<String, String> hmap) {}

    public String process(HashMap<String, String> hmap) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        BufferedReader br;
        try {
            JsonParser jsonParser = new JsonParser();
            Response response = new Response();
            int total;
            String a = hmap.get("a");
            int aInt = Integer.parseInt(a);

            if(hmap.containsKey("b")) {
                String b = hmap.get("b");
                int bInt = Integer.parseInt(b);
                total = aInt + bInt;
            } else {
                total = aInt + 1;
            }
            response.setResponse(total);
            response.setParams(hmap);

            String jsonString = gson.toJson(response);
            return jsonString;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ERROR";
    }
}
