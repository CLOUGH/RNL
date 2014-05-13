/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package rnl;
import rnl.*;
/**
 *
 * @author clough
 */
public class RegularCSA extends User{

    public RegularCSA(int user_id) {
        super(user_id);
    }   
    
    @Override
    public String getType()
    {
        return "Regular";
    }
}
