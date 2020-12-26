package com.company;

import javafx.util.Pair;

import java.util.ArrayList;

public class Instructor extends User{
    private ArrayList<Student>learners;
    private ArrayList<Course>Courses;

    void addGrades(Student s , double g , Course c){
        c.addGrades(s,g);
    }

    void publish(String message  , Course c){
        c.setPublish(c.getPublish() + "\n" + message);
    }




}
