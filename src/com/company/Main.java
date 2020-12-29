package com.company;
import javafx.util.Pair;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    Scanner input = new Scanner(System.in);
    public static void main(String[] args) throws SQLException {

        Pair <Integer, Integer>v = login();
        switch (v.getKey()){
            case 1:
                System.out.println("Student");
                Student(v.getValue());
                break;
            case 2:
                System.out.println("Instructor");
                break;
            case 3:
                System.out.println("Admin");
        }

    }
    public static void Student(int id)
    {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> s = new ArrayList<>();
        ArrayList<Course> c = new ArrayList<>();
            try {
                Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QA5TUAT:1433;databaseName=courseManegmentSystem;user=omar;password=admin");
                Statement stat = con.createStatement();
                String sqlc = "select* from course ";
                ResultSet rc = stat.executeQuery(sqlc);
                while (rc.next())
                {
                    String nameOfCourse = rc.getString("nameOfCourse");
                    String courseCode = rc.getString("courseCode");
                    String startDate = rc.getString("startDate");
                    String endDate = rc.getString("endDate");
                    int daysOfCourse = rc.getInt("daysOfCourse");
                    int numberOfHours = rc.getInt("numberOfCourse");
                    int price = rc.getInt("price");
                    String room = rc.getString("room");

                }
                String sql = "select* from student";
                ResultSet rs = stat.executeQuery(sql);
                while (rs.next()) {
                    int idtemp = rs.getInt("student_ID");
                    String StudentFname = rs.getString("student_Fname");
                    String StudentMname = rs.getString("student_Mname");
                    String StudentLname = rs.getString("student_lname");
                    int StudentGBA = rs.getInt("student_gba");
                    String []course = new String[7];
                    for (int i = 0; i < 7; i++) {
                        course[i] = rs.getString("course"+(i+1));
                    }
                    Student newstudent = new Student();
                    s.add(newstudent);
                    }

                } catch (SQLException throwables) {
                System.out.println("oops");
                throwables.printStackTrace();
            }

    }
    public static Pair<Integer , Integer> login()
            throws SQLException {
        Scanner input = new Scanner(System.in);
        System.out.print("ID: ");
        int id = input.nextInt();
        System.out.print("Password: ");
        String password = input.next();


        try {
            Connection con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QA5TUAT:1433;databaseName=courseManegmentSystem;user=omar;password=admin");
            Statement stat = con.createStatement();
            String sql = "select* from allPassword";
            ResultSet rs = stat.executeQuery(sql);


            while (rs.next()) {
                int id1 = rs.getInt("id");
                String password1 = rs.getString("pass");
                String person = rs.getString("person");
                if (id1 == id && password1.equals(password)) {
                    Integer i = id1;
                    if (person.equals("student")) {
                        Pair<Integer, Integer> s = new Pair<>(1, i);
                        return s;
                    }
                    else if (person.equals("instructor")) {
                        Pair<Integer, Integer> s = new Pair<>(2, i);
                        return s;
                    }
                    else if (person.equals("admin")) {
                        Pair<Integer, Integer> s = new Pair<>(3, i);
                        return s;
                    }
                    else
                    {
                        Pair<Integer, Integer> s = new Pair<>(null, null);
                        return s;
                    }
                }
            }

        } catch (SQLException e) {
            System.out.println("oops");
            e.printStackTrace();
        }
        Pair<Integer, Integer> s = new Pair<>(null,null);
        return s;
    }
}
