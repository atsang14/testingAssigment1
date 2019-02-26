package homework1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class User {
    // Use Java generics to avoid linear searching for users by id, makes it O(1) instead of O(n)
    // Basically use Map hashmaps instead of using an arrayList(or arrays in javascript)
    // This is equivalent to using objects in javascript instead of arrays
    private static Map<Integer, User> useridDict = new HashMap<>();
    private static ArrayList<User> allUsers = new ArrayList<>();

    public void setUsername(String username) {
        System.out.println("Line 15 You are in the USERS class setter method:\t"+username);
        this.username = username;
    }

    private  String username;

    public void setUserid(int userid) {
        this.userid = userid;
        System.out.println(userid);
    }

    private  int userid;

    public User(){
        System.out.println("Line 29 in User class\t" + this);
        allUsers.add(this);
    }

    public User(String username, int userid){
        System.out.println("Line 34 in User class");
        this.username = username;
        this.userid = userid;
        allUsers.add(this);
        useridDict.put(userid, this);
    }

    public static User getUser(int userid) {
        System.out.println("Line 41 You are in the USERS class setter method:\t"+userid);
        return useridDict.get(userid);
    }

    public void register() {
        System.out.println("Line 46 You are in the USERS class setter method:\t"+userid);
        useridDict.put(userid, this);
    }

    public static void loadAll() {
        System.out.println("Line 51 You are in the USERS class setter method:\t");
        for(int i = 0 ; i < allUsers.size(); i++) {
            allUsers.get(i).register();
        }
    }
}