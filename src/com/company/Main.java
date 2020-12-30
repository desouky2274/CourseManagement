package com.company;

import javafx.util.Pair;
import java.io.File;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.io.*;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) throws Exception{


        try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-TBQGV9O:1433;databaseName=courseManegmentSystem;user=amr;password=123");
            Statement stat = con.createStatement();
            String sql = "select* from student";
            ResultSet rs = stat.executeQuery(sql);
            while(rs.next()){
                int idtemp = rs.getInt("student_ID");
                String StudentFname = rs.getString("student_Fname");
                String StudentMname = rs.getString("student_Mname");
                String StudentLname = rs.getString("student_lname");
                double StudentGBA = rs.getDouble("student_gba");
                System.out.println(idtemp + "  "  + StudentFname + " " + StudentMname + " " + StudentLname + " " + StudentGBA);
            }
                float g = 3.2f;
                String fname="Omar";
                String mname = "Essam";
                String lname="Desouky";
                String course1 ="cs111";
                String course2 ="cs112";
                String course3="cs122";
                String course4 ="cs211";
                String  course5 ="cs221";
                String course6="cs222";
                String course7="cs321";
                sql="insert into student(student_Fname,student_Mname,student_lname,student_gba) values ('"+fname+"','"+mname+"','"+lname+"' , '"+g+"' )";
                stat.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.println("oops");
            e.printStackTrace();
        }
    }
}
