package main;

import java.awt.BorderLayout;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import rnl.LoyaltyProgram;
import rnl.Merchant;

public class SelectLoyaltyProgramJFrame extends javax.swing.JFrame {
    private Merchant merchant;
    private LoyaltyProgram selectedLoyaltyProgram;
    
    public SelectLoyaltyProgramJFrame(Merchant merchant) {
        initComponents();
        this.merchant = merchant;
        this.selectedLoyaltyProgram = null;
            
        this.setLayout(new BorderLayout());
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        loyaltyProgramJTable = new javax.swing.JTable();
        CancelJButton = new javax.swing.JButton();
        SelectJButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        loyaltyProgramJTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Program Name", "Start Date", "End Date", "Type"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(loyaltyProgramJTable);
        if (loyaltyProgramJTable.getColumnModel().getColumnCount() > 0) {
            loyaltyProgramJTable.getColumnModel().getColumn(0).setPreferredWidth(5);
        }

        CancelJButton.setText("Cancel");
        CancelJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                CancelJButtonMouseClicked(evt);
            }
        });

        SelectJButton.setText("Select");
        SelectJButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                SelectJButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 340, Short.MAX_VALUE)
                        .addComponent(CancelJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(SelectJButton, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SelectJButton)
                    .addComponent(CancelJButton))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CancelJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_CancelJButtonMouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_CancelJButtonMouseClicked

    private void SelectJButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_SelectJButtonMouseClicked
        //if merchant was not selected then pop warning
        int[] rowsSelected = loyaltyProgramJTable.getSelectedRows();
        if(rowsSelected.length > 0 && rowsSelected.length < 2){
            //store the selected merchant in the selectedMerchant variable
            try{
                selectedLoyaltyProgram = new LoyaltyProgram((int)loyaltyProgramJTable.getValueAt(rowsSelected[0], 0));
            }catch(Exception e){
                System.err.println( e.getClass().getName() + ": " + e.getMessage() );
                System.exit(0);
            }

            //close the frame
            this.setVisible(false);
            this.dispose();
        }
        else if(rowsSelected.length > 1){
            //warn user that they can only select one merchant
            JOptionPane.showMessageDialog(this,
                "You have selected too many row. Please select one row.",
                "Selection Error",  JOptionPane.WARNING_MESSAGE);
        }
        else{
            //warn the user they must select a merchant first
            JOptionPane.showMessageDialog(this,
                "You did not select any row. Please select a row.",
                "Selection Error",  JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_SelectJButtonMouseClicked

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_formWindowClosing

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CancelJButton;
    private javax.swing.JButton SelectJButton;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable loyaltyProgramJTable;
    // End of variables declaration//GEN-END:variables
    public void refreshTable()
    {
        ArrayList<LoyaltyProgram> loyaltyPrograms = LoyaltyProgram.getProgramsForMerchant(this.merchant);
        Iterator<LoyaltyProgram> loyaltyProgramIterator = loyaltyPrograms.iterator();
        
        DefaultTableModel loyaltyProgramTableModel = (DefaultTableModel) this.loyaltyProgramJTable.getModel();
        loyaltyProgramTableModel.setRowCount(0);
        
        while(loyaltyProgramIterator.hasNext()) {
           this.addRow(loyaltyProgramIterator.next());
        }
    }
    private void addRow(LoyaltyProgram loyaltyProgram){
        DefaultTableModel tableModel = (DefaultTableModel) this.loyaltyProgramJTable.getModel();
        Object[] row = new Object[]{
            loyaltyProgram.getID(),
            loyaltyProgram.getProgramName(),
            (new SimpleDateFormat("dd-MM-yyyy")).format(loyaltyProgram.getStartDate()),
            (new SimpleDateFormat("dd-MM-yyyy")).format(loyaltyProgram.getEndDate()),
            loyaltyProgram.getProgramType()
        };
        tableModel.addRow(row);
    }
    public LoyaltyProgram getSelectedLoyaltyProgram(){
        return selectedLoyaltyProgram;
    }
}
