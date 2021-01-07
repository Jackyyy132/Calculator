
import java.awt.Toolkit;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jacky
 */
public class History extends javax.swing.JFrame {
public Calculator cal = new Calculator();
    /**
     * Creates new form History
     */
    public History() throws Exception{
        initComponents();

        
        setIcon();
        
        
        HistoryTA.setEditable(false);
        try{
            BufferedReader in = new BufferedReader(new FileReader("History.txt"));
            
            
            HistoryTA.read(in, null);
            in.close();
            HistoryTA.requestFocus();


            
            
        }
        catch(IOException e){
            JOptionPane.showMessageDialog(rootPane, "Could not locate text file");
        }
        
        
        
        
        
        
        
//        FileReader file = new FileReader("History.txt");
//        BufferedReader reader = new BufferedReader(file);
//        
//        String line;
//        while ((line = reader.readLine()) != null){
//            HistoryTF.setText(line);
//        }
//        reader.close();
//        file.close();
        
        

        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GoBackButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        HistoryTA = new javax.swing.JTextArea();
        ClearHistoryButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("My History");
        setResizable(false);

        GoBackButton.setText("Go Back");
        GoBackButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        GoBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GoBackButtonActionPerformed(evt);
            }
        });

        HistoryTA.setColumns(20);
        HistoryTA.setRows(5);
        HistoryTA.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jScrollPane1.setViewportView(HistoryTA);

        ClearHistoryButton.setText("Clear History");
        ClearHistoryButton.setBorder(javax.swing.BorderFactory.createTitledBorder(""));
        ClearHistoryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ClearHistoryButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(GoBackButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 328, Short.MAX_VALUE)
                        .addComponent(ClearHistoryButton)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 294, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GoBackButton)
                    .addComponent(ClearHistoryButton))
                .addGap(16, 16, 16))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void GoBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GoBackButtonActionPerformed
        cal.ClickSound();
        Calculator Link = new Calculator();
        Link.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_GoBackButtonActionPerformed

    private void ClearHistoryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ClearHistoryButtonActionPerformed
        cal.ClickSound();
        int LogOutSelection = JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to clear password history?", "Clear password history?", JOptionPane.YES_NO_OPTION); 
        if (LogOutSelection == JOptionPane.YES_OPTION) {
            cal.ClickSound();
            if (HistoryTA.getText().equals("")){
                JOptionPane.showMessageDialog(rootPane, "Sorry buddy. There is nothing to be cleared.", "Clear History Fail", JOptionPane.INFORMATION_MESSAGE);
                cal.ClickSound();
            }
            else{
        
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("History.txt"));
            out.write("");
            out.close();
            JOptionPane.showMessageDialog(rootPane, "History cleared.", "Clear History Success", JOptionPane.INFORMATION_MESSAGE);
            
            
            Calculator Link = new Calculator();
            this.dispose();
            Link.setVisible(true);
        } catch (IOException ex) {
            Logger.getLogger(History.class.getName()).log(Level.SEVERE, null, ex);
        }
            }
        }
        else{
            cal.ClickSound();
        }
    }//GEN-LAST:event_ClearHistoryButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(History.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new History().setVisible(true);
                } catch (Exception ex) {
                    Logger.getLogger(History.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }
    
    private void setIcon(){
        setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("CalculatorLogo.JPG")));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ClearHistoryButton;
    private javax.swing.JButton GoBackButton;
    private javax.swing.JTextArea HistoryTA;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
