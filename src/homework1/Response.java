package homework1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

public class Response {
    Date date;
    HashMap params;
    User[] users;
    Posts[] posts;
    String responseCode = "OK";
    int response;
    
    public void setUsers(User[] users) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        this.date = date;
        this.users = users;
    }

    public void setPosts(Posts[] posts) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        this.date = date;
        this.posts = posts;
    }

    public void setParams(HashMap<String, String> hmap) {
        this.params = hmap;
    }

    public void setResponse(int response) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        this.date = date;
        this.response = response;
    }

    @Override
    public String toString() {
        return "Response{" +
                "date=" + date +
                ", params=" + params +
                ", users=" + Arrays.toString(users) +
                ", posts=" + Arrays.toString(posts) +
                ", responseCode='" + responseCode + '\'' +
                ", response=" + response +
                '}';
    }
}

//class ResponseHelper {
//    User[] users;
//    long theDate;
//
//    public ResponseHelper setUsers(User[] users) {
//        this.users = users;
//        return this;
//    }
//
//    public ResponseHelper setDate(long theDate) {
//        this.theDate = theDate;
//        return this;
//    }
//
//    public Response getResponse() {
//        return new Response(users, theDate);
//    }
//
//}