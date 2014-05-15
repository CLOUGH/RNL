package rnl;

import rnl.*;
import java.sql.*;
import java.util.ArrayList;

public class Merchant {
    private int reg_num;
    private int branch_num;
    private String merchant_name;
    private String address;
    private String phone;
    private String email;
    
    public Merchant(int reg_num) {
                    
       SQLiteJDBC db = new SQLiteJDBC();

       String sql = String.format("SELECT * FROM merchants WHERE reg_num ='%d'", reg_num);
       ResultSet resultSet = db.query(sql);
       try {
            if(resultSet.next()) {
                this.reg_num = resultSet.getInt("reg_num");
                this.branch_num = resultSet.getInt("branch_num");
                this.email = resultSet.getString("email");
                this.merchant_name = resultSet.getString("merchant_name");
                this.phone = resultSet.getString("phone_number");
                this.address = resultSet.getString("address");
            }
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public static ArrayList<Merchant> getAll(){
        
        SQLiteJDBC db = new SQLiteJDBC();
        ArrayList<Merchant> merchants = new ArrayList<Merchant>();
        
        String sql = "SELECT reg_num FROM merchants";
        ResultSet resultSet = db.query(sql);
        
        try {            
            while(resultSet.next()){
                Merchant merchant = new Merchant(resultSet.getInt("reg_num"));
                merchants.add(merchant);
            }
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        
        return merchants;
    }
    
    public String getName(){
        return this.merchant_name;
    }
    public int getRegNum(){
        return this.reg_num;
    }
    public String getBranch(){
        return String.valueOf(this.branch_num);
    }
    public String getAddress(){
        return this.address;
    }
    public String getEmail(){
        return this.email;
    }
}

