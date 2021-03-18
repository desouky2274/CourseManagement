/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company.gui;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
/**
 *
 * @author OmarAyman
 */
public class DeleteAdmin extends javax.swing.JFrame {

    public  static Connection con;
    public static Statement stat;
    static {
        try {
            con = Connection1.getCon(); //DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QA5TUAT:1433;databaseName=courseManegmentSystem;user=omar;password=admin");
            stat = con.createStatement();
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"SQL connection not found","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Creates new form DeleteAdmin
     */
    public DeleteAdmin() {
        initComponents();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(d.width/2-this.getSize().width/2,d.height/2 - this.getSize().height/2);
        setResizable(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        admin_id = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        back = new javax.swing.JButton();
        ok = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel3.setText("ADMIN ID");

        jLabel1.setText("DELETE ADMIN");

        back.setText("Back");
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        ok.setText("ok");
        ok.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(149, 149, 149)
                                                .addComponent(jLabel1))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(76, 76, 76)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(ok)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(back))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(8, 8, 8)
                                                                .addComponent(jLabel3)
                                                                .addGap(69, 69, 69)
                                                                .addComponent(admin_id, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                                .addContainerGap(91, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(44, 44, 44)
                                .addComponent(jLabel1)
                                .addGap(47, 47, 47)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(admin_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel3))
                                .addGap(68, 68, 68)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(back)
                                        .addComponent(ok))
                                .addContainerGap(81, Short.MAX_VALUE))
        );

        jLabel3.getAccessibleContext().setAccessibleName("Admin ID");

        pack();
    }// </editor-fold>

    private void backActionPerformed(java.awt.event.ActionEvent evt) {
        Admin m = new Admin();
        m.setVisible(true);
        dispose();
    }

    private void okActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            String idd = admin_id.getText();
            if (idd.equals("")){
                JOptionPane.showMessageDialog(null, "Empty Field", "Failed", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            int id = Integer.parseInt(admin_id.getText());

            String sql = "delete from allAdmin where admin_id=" + id;
            stat.executeUpdate(sql);
            sql = "delete from allPassword where id ="+id;
            int result = stat.executeUpdate(sql);
            if(result ==1)
            {
                JOptionPane.showMessageDialog(null,"Admin account has been deleted successfully","Success",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

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
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DeleteAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DeleteAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DeleteAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DeleteAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DeleteAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JTextField admin_id;
    private javax.swing.JButton back;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton ok;
    // End of variables declaration
}
