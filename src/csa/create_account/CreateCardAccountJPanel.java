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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import main.SelectLoyaltyProgramJFrame;
import main.SelectMerchantJFrame;
import rnl.*;

public class CreateCardAccountJPanel extends javax.swing.JPanel {
    public final static String JFRAME_TITLE = "Creat Card Account";
    private String previousTitle;
    private final JFrame mainJFrame;
    private final JPanel previousJPanel;
    private final RegularCSA csaUser;
    private final NewCustomer newCustomerJPanel;
    private final ExistingCustomer existingCustomerJPanel;
    private final SelectMerchantJFrame selectMerchantJFrame;
    private SelectLoyaltyProgramJFrame selectLoyaltyProgramJFrame;
    
    public CreateCardAccountJPanel(JFrame mainJFrame,JPanel previousJPanel,RegularCSA csaUser) {
        initComponents();
        this.mainJFrame = mainJFrame;
        previousTitle = mainJFrame.getTitle();
        mainJFrame.setTitle(JFRAME_TITLE);
        
        this.previousJPanel = previousJPanel;
        this.csaUser = csaUser;      
        
        newCustomerJPanel = new NewCustomer();
        existingCustomerJPanel = new ExistingCustomer();
        
        selectMerchantJFrame = new SelectMerchantJFrame();
        selectLoyaltyProgramJFrame = new SelectLoyaltyProgramJFrame(null);
        
        userJPanelNew.setLayout(new BorderLayout());
        userJPanelNew.add(newCustomerJPanel);    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CanelJButton = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        userJPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        userTypeJComboBox = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        SelectMechantJButton = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        merchantNameJLabel = new javax.swing.JLabel();
        SelectLoyaltyProgramJButton = new javax.swing.JButton();
        loyaltyProgramNameJLabel = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        userJPanelNew = new javax.swing.JPanel();

        CanelJButton.setText("Cancel");
        CanelJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CanelJButtonMouseClicked(evt);
            }
        });

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

        jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.LOWERED));

        SelectMechantJButton.setText("Select Merchant");
        SelectMechantJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelectMechantJButtonMouseClicked(evt);
            }
        });

        jLabel8.setText("Merchant");

        jLabel3.setText("Program");

        jLabel4.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel4.setText("Merchant : ");

        merchantNameJLabel.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        merchantNameJLabel.setText("null");

        SelectLoyaltyProgramJButton.setText("Select Loyalty Program");
        SelectLoyaltyProgramJButton.setEnabled(false);
        SelectLoyaltyProgramJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelectLoyaltyProgramJButtonMouseClicked(evt);
            }
        });

        loyaltyProgramNameJLabel.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        loyaltyProgramNameJLabel.setText("null");

        jLabel5.setFont(new java.awt.Font("Ubuntu", 0, 12)); // NOI18N
        jLabel5.setText("Program:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(merchantNameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(loyaltyProgramNameJLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(SelectMechantJButton)
                            .addComponent(jLabel8))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(84, 84, 84)
                                .addComponent(jLabel3))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(82, 82, 82)
                                .addComponent(SelectLoyaltyProgramJButton)))))
                .addContainerGap(69, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SelectMechantJButton)
                    .addComponent(SelectLoyaltyProgramJButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(merchantNameJLabel)
                    .addComponent(jLabel4)
                    .addComponent(loyaltyProgramNameJLabel)
                    .addComponent(jLabel5))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout userJPanelNewLayout = new javax.swing.GroupLayout(userJPanelNew);
        userJPanelNew.setLayout(userJPanelNewLayout);
        userJPanelNewLayout.setHorizontalGroup(
            userJPanelNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 473, Short.MAX_VALUE)
        );
        userJPanelNewLayout.setVerticalGroup(
            userJPanelNewLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 36, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(CanelJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(userJPanelNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)
                            .addComponent(userTypeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userJPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGap(26, 26, 26))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(userJPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userTypeJComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(userJPanelNew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 260, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CanelJButton)
                    .addComponent(jButton2))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents
    private void CanelJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CanelJButtonMouseClicked
        // TODO add your handling code here:
        mainJFrame.getContentPane().remove(this);
        mainJFrame.getContentPane().add(previousJPanel);

        mainJFrame.getContentPane().invalidate();
        mainJFrame.getContentPane().revalidate();
        mainJFrame.getContentPane().repaint();
        
        mainJFrame.setTitle(previousTitle);
    }//GEN-LAST:event_CanelJButtonMouseClicked
    private void userTypeJComboBoxItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_userTypeJComboBoxItemStateChanged
        // TODO add your handling code here:
        String selected_user_type = String.valueOf(userTypeJComboBox.getSelectedItem());
        /**
        *If the the user type selected is a new then load the new user form else
        * load the existing user JPanel
        */
        userJPanelNew.removeAll();
        userJPanelNew.setLayout(new BorderLayout());
        if(selected_user_type.equals("Create New")) {                    
            userJPanelNew.add(newCustomerJPanel);            
        }
        else if(selected_user_type.equals("Exisiting Customer")) {  
            existingCustomerJPanel.refreshTable();
            userJPanelNew.add(existingCustomerJPanel);
        }
        userJPanelNew.invalidate();
        userJPanelNew.validate();
        userJPanelNew.repaint();
    }//GEN-LAST:event_userTypeJComboBoxItemStateChanged

    private void SelectMechantJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectMechantJButtonMouseClicked
        //Open the selectMechantJForm
        selectMerchantJFrame.setLayout(new BorderLayout());
        selectMerchantJFrame.setVisible(true);

        //Add event when the select SelectMerchatJFrame is close get the selected
        //merchant and update the merchantNameJLabel
        selectMerchantJFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                Merchant selectedMerchant = selectMerchantJFrame.getSelectedMerchant();

                if(selectedMerchant != null) {
                    merchantNameJLabel.setText(selectedMerchant.getName());

                    //Activate the loyaltyProgramJComoboBox
                    SelectLoyaltyProgramJButton.setEnabled(true);
                    selectLoyaltyProgramJFrame = new SelectLoyaltyProgramJFrame(selectedMerchant);
                }
            }
        });
    }//GEN-LAST:event_SelectMechantJButtonMouseClicked

    private void SelectLoyaltyProgramJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectLoyaltyProgramJButtonMouseClicked
        //Open the selectLoyaltyProgramJFrame
        selectLoyaltyProgramJFrame.setVisible(true);
        selectLoyaltyProgramJFrame.refreshTable();

        //Add event when the select SelectLoyaltyProgramJFrame is close get the 
        //selected merchant and update the loyaltyProgramNameJLabel
        selectLoyaltyProgramJFrame.addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                LoyaltyProgram loyaltyProgram = selectLoyaltyProgramJFrame.getSelectedLoyaltyProgram();

                if(loyaltyProgram != null) {
                    loyaltyProgramNameJLabel.setText(loyaltyProgram.getProgramName());
                }
            }
        });
        
    }//GEN-LAST:event_SelectLoyaltyProgramJButtonMouseClicked

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CanelJButton;
    private javax.swing.JButton SelectLoyaltyProgramJButton;
    private javax.swing.JButton SelectMechantJButton;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel loyaltyProgramNameJLabel;
    private javax.swing.JLabel merchantNameJLabel;
    private javax.swing.JPanel userJPanel;
    private javax.swing.JPanel userJPanelNew;
    private javax.swing.JComboBox userTypeJComboBox;
    // End of variables declaration//GEN-END:variables
}
