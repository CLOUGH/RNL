/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package csa.create_account;

import csa.create_account.ExistingCustomer;
import csa.create_account.NewCustomer;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JPanel;
import rnl.*;

public class CreateCardAccountJPanel extends javax.swing.JPanel {
    private JFrame mainJFrame;
    private JPanel previousJPanel;
    private RegularCSA csaUser;
    private NewCustomer newCustomerJPanel;
    private ExistingCustomer existingCustomerJPanel;
    
    public CreateCardAccountJPanel(JFrame mainJFrame,JPanel previousJPanel,RegularCSA csaUser) {
        initComponents();
        this.mainJFrame = mainJFrame;
        this.previousJPanel = previousJPanel;
        this.csaUser = csaUser;      
        
        newCustomerJPanel = new NewCustomer();
        existingCustomerJPanel = new ExistingCustomer();
        
        userJPanel.setLayout(new BorderLayout());
        userJPanel.add(newCustomerJPanel);    
        
        this.addMerchantsToDropDown();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        merchantJComboBox = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jComboBox2 = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        userJPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userTypeJComboBox = new javax.swing.JComboBox();

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Create Card Account");
        jLabel2.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        merchantJComboBox.setBackground(java.awt.Color.white);

        jLabel3.setText("Program");

        jComboBox2.setBackground(java.awt.Color.white);

        jButton1.setText("Cancel");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jLabel8.setText("Merchant");

        jButton2.setText("Save");

        javax.swing.GroupLayout userJPanelLayout = new javax.swing.GroupLayout(userJPanel);
        userJPanel.setLayout(userJPanelLayout);
        userJPanelLayout.setHorizontalGroup(
            userJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        userJPanelLayout.setVerticalGroup(
            userJPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setText("User Type");

        userTypeJComboBox.setBackground(java.awt.Color.white);
        userTypeJComboBox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Create New", "Exisiting Customer" }));
        userTypeJComboBox.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                userTypeJComboBoxItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(userTypeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(userJPanel, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabel3)
                                        .addGap(170, 170, 170))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(merchantJComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(12, 12, 12)
                                        .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(14, 14, 14)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userTypeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(userJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(merchantJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jComboBox2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 154, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        mainJFrame.getContentPane().remove(this);
        mainJFrame.getContentPane().add(previousJPanel);

        mainJFrame.getContentPane().invalidate();
        mainJFrame.getContentPane().revalidate();
        mainJFrame.getContentPane().repaint();
    }//GEN-LAST:event_jButton1MouseClicked
    private void userTypeJComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_userTypeJComboBoxItemStateChanged
        // TODO add your handling code here:
        String selected_user_type = String.valueOf(userTypeJComboBox.getSelectedItem());
        /**
        *If the the user type selected is a new then load the new user form else
        * load the existing user JPanel
        */
        userJPanel.removeAll();
        userJPanel.setLayout(new BorderLayout());
        if(selected_user_type.equals("Create New")) {                    
            userJPanel.add(newCustomerJPanel);            
        }
        else if(selected_user_type.equals("Exisiting Customer")) {  
            existingCustomerJPanel.refreshTable();
            userJPanel.add(existingCustomerJPanel);
        }
        userJPanel.invalidate();
        userJPanel.validate();
        userJPanel.repaint();
    }//GEN-LAST:event_userTypeJComboBoxItemStateChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JComboBox merchantJComboBox;
    private javax.swing.JPanel userJPanel;
    private javax.swing.JComboBox userTypeJComboBox;
    // End of variables declaration//GEN-END:variables

    private void addMerchantsToDropDown()
    {
        ArrayList<Merchant> merchants = Merchant.getAll();
        Iterator<Merchant> merchantIterator = merchants.iterator();
        
        this.merchantJComboBox.removeAllItems();
        while(merchantIterator.hasNext()) {
           this.merchantJComboBox.addItem(merchantIterator.next().getMerchantName());
        }
    }
}
