package rnl;
import java.sql.*;
/**
 *
 * @author clough
 */
public class SQLiteJDBC {
    private Connection db_connection;
    private static String DB_NAME = "jdbc:sqlite:rnl.sqlite";
    
    public SQLiteJDBC()
    {
        /* The constructor for the sqlite jdbc opens a connection to
        * the database "rnl.db"
        */
        db_connection = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            db_connection = DriverManager.getConnection(DB_NAME);
        }catch(Exception e)
        {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    /*
    * executes and returns the result set (result from a query)
    * very powerful at this point
    */
    public ResultSet query(String query)
    {
        ResultSet resultSet = null;
        try{
            Statement stmt = db_connection.createStatement();
            resultSet = stmt.executeQuery(query);  
           
        }catch(Exception e)     {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        
        return resultSet;        
    }
    
}
