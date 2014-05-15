package main;

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.UIManager;

/**
 * @author clough
 */
public class RNL {
    public static void main(String[] args) {
        
        //Set the look and feel 
        try{
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            
        }catch(Exception e){
            e.printStackTrace();
        }
        
        //load main frame with main panel on start
       MainJFrame mainJFrame = new MainJFrame();
       mainJFrame.setLayout(new BorderLayout());
       mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       mainJFrame.setTitle("Login");
       //Add the main pannel to jframe
       LoginJPanel mainJPanel =  new LoginJPanel(mainJFrame);
       mainJFrame.add(mainJPanel);
       mainJFrame.setVisible(true);    
    }    
}
