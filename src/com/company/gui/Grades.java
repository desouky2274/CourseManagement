package com.company.gui;


import javax.swing.*;
import java.awt.*;
import java.sql.*;

/**
 *
 * @author OmarAyman
 */
public class Grades extends javax.swing.JFrame {

    public  static Connection con;
    public static Statement stat;
    public static int id;
    public static String courseCode;
    static {
        try {
            con = Connection1.getCon();// con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QA5TUAT:1433;databaseName=courseManegmentSystem;user=omar;password=admin");
            stat = con.createStatement();
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"SQL connection not found","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * Creates new form NewJFrame
     */
    public Grades() {
        initComponents();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(d.width/2-this.getSize().width/2,d.height/2 - this.getSize().height/2);
        setResizable(false);
    }

    public Grades(int id) {
        this.id = id;
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

        jButton1 = new javax.swing.JButton();
        Courses = new javax.swing.JComboBox<>();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                try {
                    formWindowOpened(evt);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        });

        jButton1.setText("GetGrade");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Courses.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        Courses.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CoursesActionPerformed(evt);
            }
        });

        jButton2.setText("Back");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(117, 117, 117)
                                                .addComponent(jButton2))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(59, 59, 59)
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(33, 33, 33)
                                                .addComponent(Courses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(75, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(71, 71, 71)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(Courses, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 89, Short.MAX_VALUE)
                                .addComponent(jButton2)
                                .addContainerGap())
        );

        pack();
    }// </editor-fold>




    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
        SpecificCourseGrade s = new SpecificCourseGrade(id,Courses.getSelectedItem().toString());
        s.setVisible(true);
        dispose();
    }

    private void CoursesActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {
        Student s = new Student();
        s.setVisible(true);
        dispose();
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) throws SQLException{
        try {
            String[] course = new String[7];
            int student_id = id;
            String sql = "select course1,course2,course3,course4,course5,course6,course7 from student where student_id =" + student_id + "";
            ResultSet rs = stat.executeQuery(sql);
            rs.next();
            for (int x = 0; x < 7; x++) {
                course[x] = rs.getString("course" + (x + 1));
            }

            DefaultComboBoxModel mod = new DefaultComboBoxModel(course);
            Courses.setModel(mod);
        }
        catch (SQLException e) {
            System.out.println("oops");
            e.printStackTrace();
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
                if ("FlatLaf Dark".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Grades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Grades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Grades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Grades.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Grades().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify
    private javax.swing.JComboBox<String> Courses;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    // End of variables declaration
}
