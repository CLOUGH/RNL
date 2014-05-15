package rnl;

import java.sql.ResultSet;
import java.sql.SQLException;
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
    private String password;
    private int id;
    
    public User(int user_id)  {
                  
        SQLiteJDBC db = new SQLiteJDBC();

        String sql = String.format("SELECT user_id, fname, lname, email FROM users WHERE user_id ='%d'", user_id);
        ResultSet resultSet = db.query(sql);
        try {  
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
    public User(String fname, String lname, String email, String password,String type)
    {
        this.id = -1;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.password = password;
        this.type = type;
    }
    
    /*
    *Store the data in class to database
    */
    public boolean store() throws SQLException  {      
        //check if the class was created or pulled from db
        if(this.id !=-1)
            return false;
        
        SQLiteJDBC db = new SQLiteJDBC();
        ResultSet resultSet = null;
        
        String sql = String.format(
            "INSERT INTO users (email,password,fname,lname,user_type)" +
            "VALUES ('%s','%s','%s','%s','%s');",
            this.email,this.password,this.fname, this.lname,this.type);
        
        if(db.updateQuery(sql)> 0)  {
             sql = String.format("SELECT * FROM users WHERE email='%s'",this.email);
            resultSet = db.query(sql);
        }
        if(resultSet.next()) {
            this.id = resultSet.getInt("user_id");
            db.close();
            return true;
        }
        
        db.close();
        return false;
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
            db.close();
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }        
        return user_type;
    }
    public static boolean userExist(String email){
        SQLiteJDBC db = new SQLiteJDBC();
        String sql = String.format("SELECT user_id FROM users WHERE email='%s'", email);
        ResultSet resultSet = db.query(sql);
        
        try {          
            if(resultSet.next())
                return true;
            
            db.close();
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        } 
        return false;
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
