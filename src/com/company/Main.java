package com.company;

import javafx.util.Pair;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.io.*;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception{


        ArrayList<Pair<Student , String>>  list1 = new ArrayList<>();
        ArrayList<Pair<Student , Double>>  list2 = new ArrayList<>();
        ArrayList<Instructor> list3 = new ArrayList<>();
        ArrayList<Course> list4 = new ArrayList<>();
        ArrayList<Student> list5 = new ArrayList<>();


        Course c1 = new Course("c112" , "PL" , 3 ,list3 , "CS" , "H2" , "Helwan" , 2000 , list2 , list1 , new Date() , new Date() , 90);
        Student s1 = new Student("Omar" , "Essam" , "Desouky" , 201900520 , "2274" , 3.1 , list4);
        Instructor i1 = new Instructor("Mohammed" , "El-saeed" , "Mohammed" , 201900520 , "2274" ,list5 , list4);

        Admin m1 = new Admin();
        Admin m2 = new Admin("Ahmed" , "Fouad" , "hoh" , 201900555 , "ooo");

        m1.addUser(s1);
        m1.addUser(i1);
        m1.addUser(m2);
        File allUsers = new File("D:\\Project\\allUsers.txt");
        //








    }
}
