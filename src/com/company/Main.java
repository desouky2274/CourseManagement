package com.company;
import javafx.util.Pair;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class Main {
    public  static  Connection con;
    public static Statement stat;
    static {
        try {
            con = DriverManager.getConnection("jdbc:sqlserver://DESKTOP-QA5TUAT:1433;databaseName=courseManegmentSystem;user=omar;password=admin");
            stat = con.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public static Scanner input = new Scanner(System.in);

    public Main() throws SQLException {
    }

    public static void main(String[] args) throws SQLException {
        float g = 3.1f;
        String fname="mohsen";
        String mname = "mostafa";
        String lname="mohamed";
        String course1 ="cs111";
        String course2 ="cs112";
        String course3="cs122";
        String course4 ="cs211";
        String  course5 ="cs221";
        String course6="cs222";
        String course7="cs321";

        String pass = "mmeee321";
        //insert int the DataBase
       /* String sql="insert into student(student_Fname,student_Mname,student_lname,student_gba,course1,course2,course3,course4,course5,course6,course7) values ('"+fname+"','"+mname+"','"+lname+"',0,'"+course1+"','"+course2+"','"+course3+"','"+course4+"','"+course5+"','"+course6+"','"+course7+"')";
        stat.executeUpdate(sql);
         sql="select student_id from student where student_Fname = '"+fname+"' and student_Mname = '"+mname+"' and student_lname = '"+lname+"' ";
        ResultSet rc = stat.executeQuery(sql);
      rc.next() ;
            int id = rc.getInt("student_id");
            sql = "insert into allpassword(id,pass,person)values('" + id + "','" + pass + "','student')";
            stat.executeUpdate(sql);
            */


       /* Pair <Integer, Integer>v = login();
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
        }*/
    }
    public static void Student(int id)
    {
        ArrayList<Student> s = new ArrayList<>();
        ArrayList<Course> c = new ArrayList<>();
            try {
                String sqlc = "select* from course ";
                ResultSet rc = stat.executeQuery(sqlc);
                while (rc.next())
                {
                    String courseCode = rc.getString("courseCode");
                    String nameOfCourse = rc.getString("nameOfCourse");
                    Date startDate = rc.getDate("startDate");
                    Date endDate = rc.getDate("endDate");
                    int daysOfCourse = rc.getInt("daysOfCourse");
                    int numberOfHours = rc.getInt("numberOfHours");
                    int price = rc.getInt("price");
                    String room = rc.getString("room");
                    boolean publish = rc.getBoolean("publish");
                    Course tempc = new Course(courseCode,nameOfCourse,numberOfHours,"Cs",room,"Science",price,startDate,endDate,daysOfCourse,publish);
                    c.add(tempc);
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
                    String sqlpass = "select pass from allPassword where id = "+ idtemp;
                    ResultSet ss = stat.executeQuery(sqlpass);
                    String password = null;
                    while (ss.next()) {
                         password = ss.getString("pass");
                    }
                    System.out.println(password);
                    Student newstudent = new Student(idtemp,password,StudentGBA);
                    s.add(newstudent);
                    }

                } catch (SQLException throwables) {
                System.out.println("oops");
                throwables.printStackTrace();
            }

    }
    public static Pair<Integer , Integer> login()
            throws SQLException {
        System.out.print("ID: ");
        int id = input.nextInt();
        System.out.print("Password: ");
        String password = input.next();


        try {
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
