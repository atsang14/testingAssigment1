package homework1;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // Last thing to implement is builder
        // but builders basically done ...

//        SingletonServer.run();

        SingletonServer serverObj = SingletonServer.getInstance();
        serverObj.run();
    }
}