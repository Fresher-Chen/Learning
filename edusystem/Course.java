/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.edusystem;

/**
 *
 * @author Charles Chen
 */
public class Course {
    private String courseName;
    private double creditHour;
    private int studentNum = 0;
    private double averageScore = 0;
    
    //public Course(){}
    public Course(String courseName,double creditHour) {
        this.courseName = courseName;
        this.creditHour = creditHour;
    }
    
    public String getCourseName(){
        return this.courseName;
    }
    
    public double getCreditHour(){
        return this.creditHour;
    } 
    
    public int getStudentNum(){
        return this.studentNum;
    }
    
    public double getAverageScore(){ 
        return this.averageScore;
    }
    
    /*
    public void setStudentNum(){
        this.studentNum++;
    }
    */
    
    /*
    public void setAverageScore(int Input_score){
        this.averageScore = (this.averageScore+(double)Input_score)/(double)this.studentNum;        //提高精度BigDecimal
    }*/
    
    //待写。。。
    public void addCourse(double score, String courseName){
        this.studentNum++;
        this.averageScore = (this.averageScore+score)/(double)this.studentNum;
    }
    
    public void print(){
        System.out.printf("Course Name:%s\nCredit Hour:%f\nStudent Number:%d\nAverage Score:%f",this.courseName,this.creditHour,this.studentNum,this.averageScore);
    }
}
