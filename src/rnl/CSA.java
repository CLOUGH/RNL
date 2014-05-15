package rnl;

import rnl.*;
public class CSA extends User {
    public CSA(int user_id){
        super(user_id);        
    }
    
    @Override
    public String getType()
    {
        return "CSA";
    }
}
