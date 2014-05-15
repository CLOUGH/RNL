package rnl;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author clough
 */
public class SQLiteJDBC {
    private Connection db_connection;
    private Statement stmt;
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
            stmt = db_connection.createStatement();
            resultSet = stmt.executeQuery(query);  
           
        }catch(Exception e)     {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        
        return resultSet;        
    }
    
    public int updateQuery(String query){
        
        int executeQueryResult=0;
        try {
            stmt = db_connection.createStatement();
            // execute the insert SQL stetement
            executeQueryResult = stmt.executeUpdate(query);
        } catch (SQLException e) {
             System.err.println( e.getClass().getName() + ": " + e.getMessage() );
             System.exit(0);
        }
        return executeQueryResult;
        
    }
    public void setAutoCommit(boolean value){
        try {
            db_connection.setAutoCommit(value);
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public void commit()    {
        try {
            db_connection.commit();
        } catch (SQLException e) {
             System.err.println( e.getClass().getName() + ": " + e.getMessage() );
             System.exit(0);
        }
    }
    public void close(){
        try {
            stmt.close();
            db_connection.close();
        } catch (SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    
}
