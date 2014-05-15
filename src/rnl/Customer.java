package rnl;

import rnl.*;
import java.util.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
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
            db.close();
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    } 
    public Customer(String fname, String lname, String email,String password,String gender, Date dob, String trn, String phone){
        super(fname,lname,email,password,"customer");
        
        this.gender = gender;
        this.dob = dob;
        this.trn = trn;
        this.phone = phone;       
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
            db.close();
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        
        return customers;
    }
/**
 * Creates a new customer and store it to the database
 * Same as createCustomer in the documentation
 * Name change to allow polymophism
 */
    @Override
    public boolean store() throws SQLException{
        
        if(super.store()== false){
            return false;
        }    
        else if(super.getID()==-1)
        {
            return false;
        }
        
        SQLiteJDBC db = new SQLiteJDBC();
        String sql = String.format(
            "INSERT INTO customers (user_id,gender,dob,trn,phone)" +
            "VALUES ('%d','%s','%s','%s','%s');",
            super.getID(),
            this.gender,
            (new SimpleDateFormat("dd-MM-yyyy")).format(this.dob), 
            this.trn,
            this.phone
        );
        if(db.updateQuery(sql)>0){
            db.close();
            return true;
        }
        else{
            db.close();
            return false;
        }        
    }
    
    /**
     * @TODO
     * Remove a customer from the database
     */
    public static void deleteCustomer()
    {
        
    }
    public static boolean TRNExist(String trn){
        SQLiteJDBC db = new SQLiteJDBC();
        String sql = String.format("SELECT user_id FROM customers WHERE trn='%s'", trn);
        ResultSet resultSet = db.query(sql);
        
        try {          
            if(resultSet.next()){
                db.close();
                return true;
            }            
            db.close();
        }catch(SQLException e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        } 
        
        return false;
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
