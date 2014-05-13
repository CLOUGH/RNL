package rnl;

import java.sql.ResultSet;
import rnl.SQLiteJDBC;
/**
 *
 * @author clough
 */
public class User {
    private String fname;
    private String lname;
    private String email;
    private String type;
    private int id;
    
    public User(int user_id)  {
        try {            
            SQLiteJDBC db = new SQLiteJDBC();

            String sql = String.format("SELECT user_id, fname, lname, email FROM users WHERE user_id ='%d'", user_id);
            ResultSet resultSet = db.query(sql);

            if(resultSet.next()) {
                fname = resultSet.getString("fname");
                lname = resultSet.getString("lname");
                email = resultSet.getString("email");
                id = resultSet.getInt("user_id");
            }
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    
    public static String getType(int user_id) {
        String user_type = "";
        try {            
            SQLiteJDBC db = new SQLiteJDBC();

            String sql = String.format("SELECT user_type FROM users WHERE user_id ='%d'", user_id);
            ResultSet resultSet = db.query(sql);

            if(resultSet.next()) {
                user_type = resultSet.getString("user_type");
            }
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }        
        return user_type;
    }
        
    public String getName(){
        return fname+' '+lname;
    }
    public int getID(){
        return id;
    }
    public String getType(){
        return type;
    }
    public String getEmail(){
        return email;
    }
}
