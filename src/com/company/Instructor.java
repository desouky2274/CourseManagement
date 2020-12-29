package com.company;

import javafx.util.Pair;

import java.util.ArrayList;

public class Instructor extends User{
    private ArrayList<Student>learners;
    private ArrayList<Course>Courses;

    void addGrades(Student s , double g , Course c){
        c.addGrades(s,g);
    }

    public Instructor(long id, String password, ArrayList<Student> learners, ArrayList<Course> courses) {
        super(id, password);
        this.learners = learners;
        Courses = courses;
    }

    public Instructor(String fname , String mname , String lname , long id, String password) {
        super(fname , mname , lname ,id, password);
    }

    public Instructor(ArrayList<Student> learners, ArrayList<Course> courses) {
        this.learners = learners;
        Courses = courses;
    }

    public void setLearners(ArrayList<Student> learners) {
        this.learners = learners;
    }

    public void setCourses(ArrayList<Course> courses) {
        Courses = courses;
    }

    public ArrayList<Student> getLearners() {
        return learners;
    }

    public ArrayList<Course> getCourses() {
        return Courses;
    }

    public Instructor(String fName, String mName, String lName, long id, String password, ArrayList<Student> learners, ArrayList<Course> courses) {
        super(fName, mName, lName, id, password);
        this.learners = learners;
        Courses = courses;
    }

    void publish(String message  , Course c){
        c.setPublish(c.getPublish() + "\n" + message);
    }
}
