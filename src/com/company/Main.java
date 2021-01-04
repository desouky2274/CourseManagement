package com.company;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Main {
       
    public  static  Connection con;
    public static Statement stat;
    static {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://locathost:1433;databaseName=courseManegmentSystem;user=omar;password=admin");
            stat = con.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
String s = "string_boy";
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws SQLException {

        System.out.println(con);
    }


}
