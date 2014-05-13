package rnl;
import java.sql.*;
/**
 *
 * @author clough
 */
public class SQLiteJDBC {
    private Connection db_connection;
    
    public SQLiteJDBC()
    {
        /* The constructor for the sqlite jdbc opens a connection to
        * the database "rnl.db"
        */
        db_connection = null;
        
        try {
            Class.forName("org.sqlite.JDBC");
            db_connection = DriverManager.getConnection("jdbc:sqlite:rnl.db");
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
    public ResultSet sql(String query)
    {
        ResultSet resultSet = null;
        try{
            Statement stmt = db_connection.createStatement();
            resultSet = stmt.executeQuery(query);  
            stmt.close();
        }catch(Exception e)     {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        
        return resultSet;        
    }
    
}
