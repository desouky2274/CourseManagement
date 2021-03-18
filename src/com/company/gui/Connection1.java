package com.company.gui;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public  class Connection1 {
    public  static Connection con;
    public static Statement stat;
    static {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=courseManagementSystem;user=omar415;password=omar");
            stat = con.createStatement();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null,"SQL connection not found","Error",JOptionPane.ERROR_MESSAGE);
        }
    }

    public static Connection getCon() {
        return con;
    }

    public static Statement getStat() {
        return stat;
    }
}
