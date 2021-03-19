package com.company.gui;

import javafx.util.Pair;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SignIn extends javax.swing.JFrame {

    public  static Connection con;
    public static Statement stat;
    static {
        try {
            con = Connection1.getCon();
            stat = con.createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"SQL connection not found","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    public SignIn() {
        initComponents();
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(d.width/2-this.getSize().width/2,d.height/2 - this.getSize().height/2);
        setResizable(false);
    }




    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        password = new javax.swing.JPasswordField();
        sign_in = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);


        jLabel1.setText("ID");
        jLabel2.setText("Password");

        sign_in.setText("Sign In");
        sign_in.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sign_inActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14));
        jLabel3.setText("Sign In");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(id)
                    .addComponent(password, javax.swing.GroupLayout.DEFAULT_SIZE, 125, Short.MAX_VALUE))
                .addGap(73, 73, 73))
            .addGroup(layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sign_in))
                .addContainerGap(181, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 76, Short.MAX_VALUE)
                .addComponent(sign_in)
                .addGap(59, 59, 59))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void sign_inActionPerformed(java.awt.event.ActionEvent evt) {
        Student student = new Student();
        Admin admin = new Admin();
        Instructor instructor = new Instructor();
        int id1 = Integer.parseInt( id.getText());
        String pass = password.getText();
        Pair <Integer, String> user = Login(id1,pass);
         if (user.getValue() == null)
             JOptionPane.showMessageDialog(null,"Wrong username or password");
         else if (user.getValue().equals("student")) {
            student.setID(user.getKey());
            student.setVisible(true);
            dispose();
        }
        else if (user.getValue().equals("admin")) {
            admin.setID(user.getKey());
            admin.setVisible(true);
            dispose();
        }
        else if (user.getValue().equals("instructor")) {
            instructor.setID(user.getKey());
            instructor.setVisible(true);
            dispose();
        }
    }

    public static Pair<Integer , String> Login(int ido, String p) {
        int id = ido;
        String password = p;
        try {
            String sql = "select* from allPassword"; //get all passwords from the DataBase to check if the entered password is correct
            ResultSet rs = stat.executeQuery(sql);
            while (rs.next()) {
                int id1 = rs.getInt("id");
                String password1 = rs.getString("pass");
                String person = rs.getString("person");
                if (id1 == id && password1.equals(password)) {
                    Integer i = id1;
                    return new Pair<>(i,person);
                }
            }

        } catch (SQLException e) {
            System.out.println("oops");
            e.printStackTrace();
        }
        Pair<Integer, String> s = new Pair<>(null,null);
        return s;
    }

    public static void main(String args[]) {

        try {
                for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                        if ("Windows".equals(info.getName())) {
                            javax.swing.UIManager.setLookAndFeel(info.getClassName());
                            break;
                        }
                    }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignIn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignIn().setVisible(true);
            }
        });
    }

    private javax.swing.JTextField id;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField password;
    private javax.swing.JButton sign_in;
}
