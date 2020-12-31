/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.company;

import java.sql.*;
import java.util.logging.*;


/**
 *
 * @author USER
 */
public class CourseManagmentSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         /*String url;
        url = "jdbc:sqlserver://DESKTOP-67MM857:1433;databaseName=courseManegmentSystem";
         String username = "root";
         String password ="root";*/
        
        try { 
            //Connection connection =DriverManager.getConnection(url, username, password);
            Class.forName("com.microsoft.sqlserver.jdb.SQLserverDriver");
            Connection con =DriverManager.getConnection("jdbc:sqlserver://DESKTOP-67MM857:1433;databaseName=courseManegmentSystem;user=root;password=root");
            System.out.println("done");
        
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CourseManagmentSystem.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(CourseManagmentSystem.class.getName()).log(Level.SEVERE, null, ex);
        } 
         
        
        
            /* try {
            
            Class.forName("com.microsoft.sqlserver.jdb.SQLServerDriver");
            System.out.println("done");
            Connection con =DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=courseManegmentSystem;user=root;password=root");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from course");
            while(rs.next())
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
            con.close();
            } catch (Exception e) {
            System.out.println("oops");
            System.out.println(e);
            }*/
     
    }
    
}
