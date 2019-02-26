package homework1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Posts {
    // Use Java generics to avoid linear searching for users by id, makes it O(1) instead of O(n)
    // Basically use Map hashmaps instead of using an arrayList(or arrays in javascript)
    // This is equivalent to using objects in javascript instead of arrays
    private static Map<Integer, Posts> useridDict = new HashMap<>();
    private static ArrayList<Posts> allUsers = new ArrayList<>();

    public void setData(String data) {
        System.out.println("Line 15 You are in the USERS class setter method:\t"+data);
        this.data = data;
    }

    private  String data;

    public void setPostid(int postid) {
        System.out.println("Line 15 You are in the USERS class setter method:\t"+data);
        this.postid = postid;
    }

    private  int postid;

    public void setUserid(int userid) {
        System.out.println("Line 22 in User Class setUserid Method");
        this.userid = userid;
        System.out.println(userid);
    }

    private  int userid;

    public Posts(){
        System.out.println("Line 29 in User class\t" + this);
        allUsers.add(this);
    }

    public Posts(String data, int userid, int postid) {
        System.out.println("Line 34 in User class");
        this.data = data;
        this.userid = userid;
        this.postid = postid;
        allUsers.add(this);
        useridDict.put(userid, this);
    }

    public static Posts getUser(int userid) {

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