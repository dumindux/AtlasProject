/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package projectatlas;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

/**
 *
 * @author Dumindu
 */
public class LogIn extends javax.swing.JFrame {

    /**
     * Creates new form LogIn
     */
    /*
     * subject to change if different types of users are added
     */
    public LogIn() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jPasswordField1 = new javax.swing.JPasswordField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(610, 300));
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel7.setText("Cosmox Software Developers. All rights reserved.");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 254, 250, 20);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel6.setText("Log in");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(40, 10, 100, 50);

        jLabel1.setText("Username");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(270, 30, 90, 14);
        getContentPane().add(jLabel5);
        jLabel5.setBounds(256, 0, 0, 426);

        jLabel2.setText("Password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(270, 70, 110, 14);

        jTextField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField1ActionPerformed(evt);
            }
        });
        getContentPane().add(jTextField1);
        jTextField1.setBounds(370, 20, 122, 30);
        getContentPane().add(jPasswordField1);
        jPasswordField1.setBounds(370, 60, 122, 30);

        jButton1.setText("Login");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(270, 100, 90, 23);

        jButton2.setText("Cancel");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(400, 100, 90, 23);
        getContentPane().add(jLabel3);
        jLabel3.setBounds(128, 0, 0, 0);

        jLabel4.setIcon(new javax.swing.ImageIcon("C:\\Users\\Dumindu\\Documents\\NetBeansProjects\\ProjectAtlas\\New folder (2)\\Finishedproductwindow_2.jpg")); // NOI18N
        getContentPane().add(jLabel4);
        jLabel4.setBounds(0, 0, 600, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        /*
         * Loads relevent user interface according to the user access level after authentication
         */
        String username=jTextField1.getText();
        String password=new String(jPasswordField1.getPassword());
        System.out.println("hey bro ");
        //MySqlPassword.createConnection();
       // UserTableProxy usrProxy=UserTableProxy.getUserTableProxy();
        User user=UserFactory.getUser(username);
        boolean access=false;
        if(user==null)
        {
            jTextField1.setText("");
            jPasswordField1.setText("");
            jLabel3.setText("User does not exist");
            JOptionPane.showMessageDialog(this,"User does not exist", "Login error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        else
        {
            try {
                access=UserPasswordMatch.compareData(user, password);
            } catch (Exception ex) {
                Logger.getLogger(LogIn.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error");
            }
        }
//        System.out.println("hey bro "+type);
        if(access)//if access is granted checks for type to decide the user interface
        {
            if(user instanceof Manager)
            {
                new ManagerWindow(user).setVisible(true);
            }
            else if(user instanceof StoreKeeperFactory)
            {
                new StoreKeeperFactoryWindow(user).setVisible(true);
                
            }
            else if(user instanceof StoreKeeperWarehouse)
            {
                new StoreKeeperFactoryWindow(user).setVisible(true);
            }
            else if(user instanceof RawMaterialOfficerWarehouse)
            {
                new RawMaterialOfficerWarehouseWindow(user).setVisible(true);
            }
            else if(user instanceof RawMaterialOfficerFactory)
            {
                new RawMaterialOfficerFactoryWindow(user).setVisible(true);
            }
            else if(user instanceof FinishedMaterialOfficer)
            {
                new FinishedMaterialOfficerWindow(user).setVisible(true);
            }
            User.currentUser=user;
            this.setVisible(false);
        }
        else
        {
            jTextField1.setText("");
            jPasswordField1.setText("");
            jLabel3.setText("Ivalid login credentials");
            JOptionPane.showMessageDialog(this,"Ivalid login credentials", "Login error", JOptionPane.ERROR_MESSAGE);
            
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_jButton2ActionPerformed

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
                   // javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LogIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LogIn().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
