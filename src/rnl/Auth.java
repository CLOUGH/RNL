package rnl;
import rnl.SQLiteJDBC;
import java.sql.*;

/**
 * @author clough
 */
public class Auth {
    /**
     * Returns the user id for the account with matching username & password
     * if not found return -1
     * @param user_email
     * @param user_password
     * @return user_id
     */
    public static int login(String user_email, String user_password)
    {       
        
        int user_id = -1;
        try {
            SQLiteJDBC db = new SQLiteJDBC();
            
            String sql = String.format("SELECT user_id FROM users WHERE email='%s' AND password='%s'",user_email,user_password);
            ResultSet result_set = db.query(sql);
            
            if(result_set!=null && result_set.next()!=false ) {
                user_id = result_set.getInt("user_id");                
            }
        }catch(Exception e)  {
          System.err.println( e.getClass().getName() + ": " + e.getMessage() );
          System.exit(0);
        }
        return user_id;
    }
}
