package main;

import java.awt.BorderLayout;
import javax.swing.JFrame;

/**
 * @author clough
 */
public class RNL {
    public static void main(String[] args) {
        //load main frame with main panel on start
       MainJFrame mainJFrame = new MainJFrame();
       mainJFrame.setLayout(new BorderLayout());
       mainJFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
       //Add the main pannel to jframe
       MainJPanel mainJPanel =  new MainJPanel();
       mainJFrame.add(mainJPanel);
       
       mainJFrame.pack();
       mainJFrame.setVisible(true);    
    }    
}
