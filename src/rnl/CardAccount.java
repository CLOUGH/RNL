package rnl;

import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import rnl.*;

public class CardAccount {
    private int account_num;
    private Customer customer;
    private Date expiry_date;
    private CSA issuer;
    private int points_earned;
    private LoyaltyProgram loyalty_program;
    
    public CardAccount(int account_num){
        
       SQLiteJDBC db = new SQLiteJDBC();

       String sql = String.format("SELECT * FROM card_account WHERE account_num ='%d'", account_num);
       ResultSet resultSet = db.query(sql);
       try {
            if(resultSet.next()) {
                this.account_num = resultSet.getInt("account_num");
                this.customer = new Customer(resultSet.getInt("user_id"));
                this.expiry_date = resultSet.getDate("email");
                this.issuer = new CSA(resultSet.getInt("issuer"));
                this.points_earned = resultSet.getInt("points_earned");
                this.loyalty_program = new LoyaltyProgram(resultSet.getInt("loyalty_program"));
            }
            db.close();
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
    }
    public CardAccount(Customer customer, Date expiry_date, CSA issuer, int points_earned, LoyaltyProgram loyaltyProgram){
        this.account_num = -1;
        this.customer = customer;
        this.expiry_date = expiry_date;
        this.issuer = issuer;
        this.points_earned = points_earned;
        this.loyalty_program = loyaltyProgram;
    }
    public static ArrayList<CardAccount> getAll(){
        SQLiteJDBC db = new SQLiteJDBC();
        ArrayList<CardAccount> card_accounts = new ArrayList<CardAccount>();
        
        String sql = "SELECT account_num FROM card_accounts";
        ResultSet resultSet = db.query(sql);
        
        try {            
            while(resultSet.next()){
                CardAccount card_account = new CardAccount(resultSet.getInt("account_num"));
                card_accounts.add(card_account);
            }
            db.close();
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        
        return card_accounts;
    }
    public static ArrayList<CardAccount> getCardAccounts(Customer customer){
        SQLiteJDBC db = new SQLiteJDBC();
        ArrayList<CardAccount> card_accounts = new ArrayList<CardAccount>();
        
        String sql = String.format("SELECT account_num FROM card_accounts WHERE user_id='%d'",customer.getID());
        ResultSet resultSet = db.query(sql);
        
        try {            
            while(resultSet.next()){
                CardAccount card_account = new CardAccount(resultSet.getInt("account_num"));
                card_accounts.add(card_account);
            }
            db.close();
        }catch(Exception e) {
            System.err.println( e.getClass().getName() + ": " + e.getMessage() );
            System.exit(0);
        }
        
        return card_accounts;
    }
    public boolean store(){
        if(this.account_num == -1)
            return false;
        SQLiteJDBC db = new SQLiteJDBC();
        String sql = String.format(
            "INSERT INTO card_accounts(account_num,loyalty_program, user_id,expiry_date,issuer,points_earned)" +
            "VALUES('%d','%d','%d', '%s','%d','%d');",
            this.account_num,
            this.loyalty_program.getID(),
            this.customer.getID(),
            (new SimpleDateFormat("dd-MM-yyyy")).format(this.expiry_date), 
            this.issuer.getID(),
            this.points_earned
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
    public int getAccountNum(){
        return account_num;
    }
    public Customer getUser(){
        return customer;
    }
    public Date getExpiryDate(){
        return expiry_date;
    }
    public CSA getIssuer(){
        return issuer;
    }
    public int getPointsEarned(){
        return points_earned;
    }
    public LoyaltyProgram getProgram(){
        return loyalty_program;
    }    
}
