package rnl;


import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class LoyaltyProgram {
    private int id;
    private Merchant merchant;
    private String program_name;
    private Date start_date;
    private Date end_date;
    private String program_type;
    private String description;
    
    public LoyaltyProgram(int id){
       SQLiteJDBC db = new SQLiteJDBC();

       String sql = String.format("SELECT * FROM loyalty_programs WHERE id ='%d'", id);
       ResultSet resultSet = db.query(sql);
       try {
            if(resultSet.next()) {
                this.id = resultSet.getInt("id");
                this.merchant = new Merchant(resultSet.getInt("merchant"));
                this.program_name = resultSet.getString("program_name");
                this.start_date = (new SimpleDateFormat("yyy-MM-dd")).parse(resultSet.getString("start_date"));
                this.end_date = (new SimpleDateFormat("yyy-MM-dd")).parse(resultSet.getString("end_date"));
                this.program_type = resultSet.getString("program_type");
                this.description = resultSet.getString("description");
            }
            db.close();
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }       
    }
    public static ArrayList<LoyaltyProgram> getProgramsForMerchant(Merchant merchant){
       
        SQLiteJDBC db = new SQLiteJDBC();
        ArrayList<LoyaltyProgram> loyaltyPrograms = new ArrayList<LoyaltyProgram>();
        
        String sql = String.format("SELECT id FROM loyalty_programs WHERE merchant ='%d'", merchant.getRegNum());
        ResultSet resultSet = db.query(sql);
        
        try {            
            while(resultSet.next()){
                LoyaltyProgram loyaltyProgram = new LoyaltyProgram(resultSet.getInt("id"));
                loyaltyPrograms.add(loyaltyProgram);
            }
            db.close();            
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        
        return loyaltyPrograms;
        
    }
    public int getID(){
        return id;
    }
    public Merchant getMerchant(){
        return merchant;
    }
    public String getProgramName(){
        return program_name;
    }
    public Date getStartDate(){
        return start_date;
    }
    public Date getEndDate(){
        return end_date;
    }
    public String getProgramType(){
        return program_type;
    }
    public String getDescription(){
        return description;
    }
}
