package homework1;
import java.util.HashMap;

public class Factory {
    public Processor getInstance(String str, HashMap<String, String> params) {
        // Don't forget to handle errors like if user enters a string for userid=
        switch(str) {
            case "/math/add":
                return new MathProcessor(params);
            case "/users":
                return new UserProcessor(params);
            case "/posts":
                return new PostProcessor(params);
            default:
                return new Error();
        }
    }
}