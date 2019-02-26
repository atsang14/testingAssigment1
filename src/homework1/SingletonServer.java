package homework1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class SingletonServer {
    private static SingletonServer ourInstance = new SingletonServer();

    public static SingletonServer run() {
        return getInstance();
    }

    private static SingletonServer getInstance() {
        if(ourInstance == null) {
            ourInstance = new SingletonServer();
        }
        return ourInstance;
    }

    private SingletonServer() {
        ServerSocket ding;
        Socket dong = null;
        String resource = null;
        String responseString = "";
        try {
            // checks port 3001 if it's open
            ding = new ServerSocket(3001);
            System.out.println("Opened socket " + 3001);
            while (true) {
                // keeps listening for new clients, one at a time
                try {
                    dong = ding.accept(); // waits for client here
                    // does not run any code until client accepts
                } catch (IOException e) {
                    System.out.println("Error opening socket");
                    System.exit(1);
                }

                System.out.println("Line 26 is here");
                InputStream stream = dong.getInputStream();
                BufferedReader in = new BufferedReader(new InputStreamReader(stream));
                try {
                    // read the first line to get the request method, URI and HTTP version
                    String line = in.readLine();
                    System.out.println("----------REQUEST START---------");
                    System.out.println("----------"+line+"---------");
                    String urlToParse = line;
                    if(line != null) {
                        // Split spaces from get GET / HTTP/1.1
                        String delims = "[ ]+";
                        String[] test = urlToParse.split(delims);
                        try {

                            // Seperate since '?' is start of params
                            String delims2 = "[?]+";
                            String[] paramsArray = test[1].split(delims2);

                            HashMap<String, String> hmap = new HashMap<String, String>();
                            String paramsToTrim = paramsArray[1];

                            // segregate each param
                            String delims3 = "[=&]+";
                            String[] params = paramsToTrim.split(delims3);

                            for (int i = 0; i < params.length; i++) {

                                // even index are keys, odd index are values
                                if (i % 2 == 0) {
                                    hmap.put(params[i], params[i + 1]);
                                }
                            }

                            // Create factory
                            Factory factoryEndpoints = new Factory();

                            // Make if state if hmap keys are a b or userid
                            // else responseString = "Error"
                            Processor obj = factoryEndpoints.getInstance(paramsArray[0], hmap);
                            responseString = obj.process(hmap);

                        } catch(ArrayIndexOutOfBoundsException | NumberFormatException e) {
                            responseString = "ERROR";
                        }
                    }

                    // Need to handle if "b" Parameter is a number rather than "b" "

                    System.out.println("LINE 46 x: " + responseString);
                    System.out.println("-------------------");
                    // read only headers
                    line = in.readLine();
                    while (line != null && line.trim().length() > 0) {
                        int index = line.indexOf(": ");
                        if (index > 0) {
                            System.out.println(line);
                        } else {
                            break;
                        }
                        line = in.readLine();
//                        System.out.println("+++++"+line+"+++++");
                    }
                    System.out.println("----------REQUEST END---------\n\n");
                } catch (IOException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("Error reading");
                    System.exit(1);
                }

                BufferedOutputStream out = new BufferedOutputStream(dong.getOutputStream());
                PrintWriter writer = new PrintWriter(out, true);  // char output to the client

                // every response will always have the status-line, date, and server name
                writer.println("HTTP/1.1 200 OK");
                writer.println("Server: TEST");
                writer.println("Connection: close");
                writer.println("Content-type: text/html");
                writer.println("");

//                JsonParser parser = new JsonParser();
//                JsonObject responseJson = parser.parse(responseString).getAsJsonObject();

                // Body of our response
                writer.println("<h1>Some cool response!</h1>");
//                writer.println(responseJson);
                writer.println(responseString);

                dong.close();
            }
        } catch (IOException e) {
            System.out.println("Error opening socket");
            System.exit(1);
        }
    }
}