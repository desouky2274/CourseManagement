package com.company;

import java.util.ArrayList;

public class Student extends User{
    private double gpa;
    private ArrayList<Course> courses;

    public double getGrade(Course c){
        for(int x=0; x<c.getGrades().size(); x++){
            if(this.getId() == c.getGrades().get(x).getKey().getId())
                return c.getGrades().get(x).getValue();
        }
        return 0.0;
    }

    public void makeSurvey(Course c , String s){
        c.makeSurvey(this , s);
    }

    public Student(){
    }

    public Student(long gpa){
        this.gpa = gpa;
    }

    public Student(long id, String password, double gpa, ArrayList<Course> courses) {
        super(id, password);
        this.gpa = gpa;
        this.courses = courses;
    }

    public Student(double gpa, ArrayList<Course> courses) {
        this.gpa = gpa;
        this.courses = courses;
    }

    public Student(String fName, String mName, String lName, long id, String password, double gpa, ArrayList<Course> courses) {
        super(fName, mName, lName, id, password);
        this.gpa = gpa;
        this.courses = courses;
    }

    public String AllCourses(){
        return courses.toString();
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public ArrayList<Course> getCourses() {
        return courses;
    }

    public void setCourses(ArrayList<Course> courses) {
        this.courses = courses;
    }

    public void updateInfo(double gpa){
        this.gpa = gpa;
    }
}
