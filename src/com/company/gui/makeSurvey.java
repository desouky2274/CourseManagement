package com.company.gui;

import javax.swing.*;
import java.awt.*;
import java.sql.*;



public class makeSurvey extends javax.swing.JFrame {

    public  static Connection con;
    public static Statement stat;
    public static int id;//Student ID

    static {
        try {
            con = Connection1.getCon();
            stat = con.createStatement();
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"SQL connection not found","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public makeSurvey() {
        initComponents();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();//Make the window at the center of the screen
        this.setLocation(d.width/2-this.getSize().width/2,d.height/2 - this.getSize().height/2);
    }

    public makeSurvey(int id) {
        this.id = id;
        initComponents();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(d.width/2-this.getSize().width/2,d.height/2 - this.getSize().height/2);
    }

    @SuppressWarnings("unchecked")
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

        jLabel1.setText("Select Course");
        jButton1.setText("Submit Survey");
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
        Avarage.setText("Average");

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
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
            Student s = new Student();
             s.setVisible(true);
            dispose();
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
         try {
            String[] course = new String[7];
            int student_id = id;
            String sql = "select course1,course2,course3,course4,course5,course6,course7 from student where student_id =" + student_id;//Selecting all courses that Student had assigned
            ResultSet rs = stat.executeQuery(sql);
            rs.next();
            for (int x = 0; x < 7; x++) {//Putting these courses in an array
                if (rs.getString("course" + (x + 1)) != null)
                course[x] = rs.getString("course" + (x + 1));
            }
        DefaultComboBoxModel mod = new DefaultComboBoxModel(course);//Make new ComboBox to prevent adding same courses again
        select_course.setModel(mod);
    }
    catch (SQLException e) {
            System.out.println("oops");
            e.printStackTrace();
        }
    }
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws SQLException {
       String survey =null;
       String sql;
       if(Excellent.isSelected())
        survey="Excellent";

    else if(Good.isSelected())
        survey="Good";

    else if(Avarage.isSelected())
        survey="Avarage";

    else if(poor.isSelected())
        survey="poor";

    else if(Very_poor.isSelected())
        survey="Very_poor";

    if (survey != null) {
        try {
            sql = "UPDATE " + select_course.getSelectedItem() + " SET survey = '" + survey + "' WHERE studentId = " + id;
            int result = stat.executeUpdate(sql);
            if (result == 1)
                JOptionPane.showMessageDialog(null,"Thanks for filling this survey","Success",JOptionPane.INFORMATION_MESSAGE);
            System.out.println("done for now");
        }catch (SQLException ex){
            ex.printStackTrace();
        }
    }
    }

    private void ExcellentActionPerformed(java.awt.event.ActionEvent evt) {
    }

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(makeSurvey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(makeSurvey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(makeSurvey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(makeSurvey.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new makeSurvey().setVisible(true);
            }
        });
    }
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
}
