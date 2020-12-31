package com.company;

import javafx.util.Pair;
import java.util.ArrayList;
import java.util.Date;

public class Course {
    private String courseCode;
    private String courseName;
    private int numberOfHours;
    private ArrayList<Instructor>list;
    private String parentCourse;
    private String room;
    private String branch;
    private double price;
    private final int maxGrade = 100;
    private ArrayList<Pair<Student  , Double >> grades;
    private ArrayList<Pair<Student  , String>> survey;
    private Date startDate;
    private Date endDate;
    private int daysOfCourse;
    private boolean publish;

    public void makeSurvey(Student ss ,String s){
        survey.add(new Pair<>(ss , s));
    }

    public String toString(){
        return courseName + " " + courseCode + "\n";
    }

    public Course(String courseCode, String courseName, int numberOfHours, String parentCourse, String room, String branch, double price, Date startDate, Date endDate, int daysOfCourse, boolean publish) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.numberOfHours = numberOfHours;
        this.parentCourse = parentCourse;
        this.room = room;
        this.branch = branch;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.daysOfCourse = daysOfCourse;
        this.publish = publish;
    }

    public Course(String courseCode, String courseName, int numberOfHours, ArrayList<Instructor> list, String parentCourse, String room, String branch, double price, ArrayList<Pair<Student, Double>> grades, ArrayList<Pair<Student, String>> survey, Date startDate, Date endDate, int daysOfCourse) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.numberOfHours = numberOfHours;
        this.list = list;
        this.parentCourse = parentCourse;
        this.room = room;
        this.branch = branch;
        this.price = price;
        this.grades = grades;
        this.survey = survey;
        this.startDate = startDate;
        this.endDate = endDate;
        this.daysOfCourse = daysOfCourse;
    }

    public Course(String courseCode, String courseName, int numberOfHours, ArrayList<Instructor> list, String parentCourse, String room, String branch, double price, Date startDate, Date endDate, int daysOfCourse) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.numberOfHours = numberOfHours;
        this.list = list;
        this.parentCourse = parentCourse;
        this.room = room;
        this.branch = branch;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.daysOfCourse = daysOfCourse;
    }

    public Course(String courseCode, String courseName, int numberOfHours,  String parentCourse, String room, String branch, double price, Date startDate, Date endDate, int daysOfCourse) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.numberOfHours = numberOfHours;
        this.parentCourse = parentCourse;
        this.room = room;
        this.branch = branch;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.daysOfCourse = daysOfCourse;
    }

    public void view(){
        System.out.println(publish);
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public void setNumberOfHours(int numberOfHours) {
        this.numberOfHours = numberOfHours;
    }

    public void setList(ArrayList<Instructor> list) {
        this.list = list;
    }

    public void setParentCourse(String parentCourse) {
        this.parentCourse = parentCourse;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setGrades(ArrayList<Pair<Student, Double>> grades) {
        this.grades = grades;
    }

    public void setSurvey(ArrayList<Pair<Student, String>> survey) {
        this.survey = survey;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setDaysOfCourse(int daysOfCourse) {
        this.daysOfCourse = daysOfCourse;
    }

    public void setPublish(boolean publish) {
        this.publish = publish;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public int getNumberOfHours() {
        return numberOfHours;
    }

    public ArrayList<Instructor> getList() {
        return list;
    }

    public String getParentCourse() {
        return parentCourse;
    }

    public String getRoom() {
        return room;
    }

    public String getBranch() {
        return branch;
    }

    public double getPrice() {
        return price;
    }

    public ArrayList<Pair<Student, Double>> getGrades() {
        return grades;
    }

    public ArrayList<Pair<Student, String>> getSurvey() {
        return survey;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public int getDaysOfCourse() {
        return daysOfCourse;
    }

    public boolean getPublish() {
        return publish;
    }

    public void addGrades(Student s , double g){
        grades.add(new Pair(s , g));
    }

}
