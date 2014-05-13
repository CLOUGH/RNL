package rnl;

import rnl.*;
import java.sql.*;
import java.util.ArrayList;

public class Customer extends User{
    private String gender;
    private Date  dob;
    private String trn;
    private String phone;
    
    public Customer(int user_id) {
        super(user_id);
        try {            
            SQLiteJDBC db = new SQLiteJDBC();

            String sql = String.format("SELECT * FROM customers WHERE user_id ='%d'", user_id);
            ResultSet resultSet = db.query(sql);

            if(resultSet.next()) {
                gender = resultSet.getString("gender");
                dob = resultSet.getDate("dob");
                trn = resultSet.getString("trn");
                phone = resultSet.getString("phone");
            }
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    } 
    public static ArrayList<Customer> getAll(){
        
        SQLiteJDBC db = new SQLiteJDBC();
        ArrayList<Customer> customers = new ArrayList<Customer>();
        
        String sql = "SELECT * FROM customers";
        ResultSet resultSet = db.query(sql);
        
        try {            
            while(resultSet.next()){
                Customer customer = new Customer(resultSet.getInt("user_id"));
                customers.add(customer);
            }
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        
        return customers;
    }
    /**
     * @TODO
     * Creates a new customer and store it to the database
     */
    public static void createCustomer(){
        
    }
    
    /**
     * @TODO
     * Remove a customer from the database
     */
    public static void deleteCustomer()
    {
        
    }
    
    public String getGender(){
        return gender;
    }
    public Date getDOB(){
        return dob;
    }    
    public String getTRN(){
        return trn;
    }    
    public String getPhone(){
        return phone;
    }
    
}
