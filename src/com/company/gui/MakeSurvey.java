package com.company.gui;

import javax.swing.*;
import java.sql.*;



public class MakeSurvey extends javax.swing.JFrame {

    public  static Connection con;
    public static Statement stat;
    public static int id;
    static {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QA5TUAT:1433;databaseName=courseManegmentSystem;user=omar;password=admin");
            stat = con.createStatement();
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"SQL connection not found","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public MakeSurvey() {
        initComponents();
    }
    public MakeSurvey(int id) {
        this.id = id;
        initComponents();
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        select_course = new javax.swing.JComboBox<>();
        Excellent = new javax.swing.JRadioButton();
        Good = new javax.swing.JRadioButton();
        Avarage = new javax.swing.JRadioButton();
        poor = new javax.swing.JRadioButton();
        Very_poor = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("select coure");

        jButton1.setText("SubmitSurvey");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    jButton1ActionPerformed(evt);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        buttonGroup.add(Excellent);
        Excellent.setText("Excellent");
        Excellent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExcellentActionPerformed(evt);
            }
        });

        buttonGroup.add(Good);
        Good.setText("Good");

        buttonGroup.add(Avarage);
        Avarage.setText("Avarage");

        buttonGroup.add(poor);
        poor.setText("Poor");

        buttonGroup.add(Very_poor);
        Very_poor.setText("Very poor");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 79, Short.MAX_VALUE)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(select_course, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(78, 78, 78))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(Excellent)
                    .addComponent(Avarage)
                    .addComponent(Very_poor)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(poor)
                        .addGap(23, 23, 23))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(Good)
                        .addGap(19, 19, 19)))
                .addGap(126, 126, 126))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(select_course, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Excellent)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Good)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Avarage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(poor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Very_poor)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
            Student s = new Student();
             s.setVisible(true);
            dispose();



        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
         try {
            String[] course = new String[7];
            int student_id = id;
            String sql = "select course1,course2,course3,course4,course5,course6,course7 from student where student_id =" + student_id;
            ResultSet rs = stat.executeQuery(sql);
            rs.next();
            for (int x = 0; x < 7; x++) {
                if (rs.getString("course" + (x + 1)) != null)
                course[x] = rs.getString("course" + (x + 1));
            }
             System.out.println(course[0]);

        DefaultComboBoxModel mod = new DefaultComboBoxModel(course);
        select_course.setModel(mod);
    }
    catch (SQLException e) {
            System.out.println("oops");
            e.printStackTrace();
        }
    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {//GEN-FIRST:event_jButton1ActionPerformed
       String survey =null;
       String sql;
       if(Excellent.isSelected())
    {
        survey="Excellent";
    }
    else if(Good.isSelected())
    {
        survey="Good";
    }
    else if(Avarage.isSelected())
    {
        survey="Avarage";
    }
    else if(poor.isSelected())
    {
        survey="poor";
    }
    else if(Very_poor.isSelected())
    {
        survey="Very_poor";
    }
    if (survey != null)
    {
        try {
            id = 10032;
            System.out.println(id);
            sql = "UPDATE " + select_course.getSelectedItem() + " SET survey = '" + survey + "' WHERE studentId = " + 10032;
            System.out.println("done");
            int result = stat.executeUpdate(sql);
            if (result == 1){
                JOptionPane.showMessageDialog(null,"Thanks for filling this survey","Success",JOptionPane.INFORMATION_MESSAGE);
            }
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }

    }

    private void ExcellentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExcellentActionPerformed

    }

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
            java.util.logging.Logger.getLogger(MakeSurvey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MakeSurvey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MakeSurvey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MakeSurvey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MakeSurvey().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Avarage;
    private javax.swing.JRadioButton Excellent;
    private javax.swing.JRadioButton Good;
    private javax.swing.JRadioButton Very_poor;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JRadioButton poor;
    private javax.swing.JComboBox<String> select_course;
    // End of variables declaration//GEN-END:variables
}
